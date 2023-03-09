package com.honey.randomusers.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.honey.data.repository.MainRepository
import com.honey.randomusers.R
import com.honey.randomusers.extensions.data.fromAppToDataList
import com.honey.randomusers.extensions.data.fromDataToAppList
import com.honey.randomusers.screens.main.model.MainEffect
import com.honey.randomusers.screens.main.model.MainEvent
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.model.SpeakerItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.exitProcess

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _mainViewState = MutableStateFlow<MainViewState>(MainViewState.Loading)
    val mainViewState: StateFlow<MainViewState> = _mainViewState

    private val _mainEffect = MutableSharedFlow<MainEffect>(extraBufferCapacity = 1)
    val mainEffect : SharedFlow<MainEffect> = _mainEffect.asSharedFlow()

    init {
        Log.d("MyLog", "MainViewModel Create ${R.drawable.img_noimg}")
    }

    //тут мы исходя из стейта отправляем Event(действие пользователя) куда нужно
    fun obtainEvent(event: MainEvent) {
        when (mainViewState.value) {
            is MainViewState.Display -> reduce(event, mainViewState.value as MainViewState.Display)
            is MainViewState.Loading -> reduce(event, mainViewState.value as MainViewState.Loading)
            is MainViewState.Search -> reduce(event, mainViewState.value as MainViewState.Search)
            is MainViewState.OnExit -> reduce(event, mainViewState.value as MainViewState.OnExit)
            is MainViewState.FavLimit -> reduce(event, mainViewState.value as MainViewState.FavLimit)
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.FavLimit) {
        when (event){
            is MainEvent.OnBackPress -> {
                performLoadPage()
            }
            else -> {}
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Display) {
        when (event) {
            is MainEvent.OnCardClicked -> {
                performItemClick(event.cardModel)
            }
            is MainEvent.OnAddFavClicked -> {
                performFavoriteClick(event.itemId, event.newValue, currentState)
            }
            is MainEvent.SearchEnter -> {
                performSearchEnter(event.searchText)
            }
            is MainEvent.OnBackPress -> {
                performSureForExit()
            }
            is MainEvent.ReloadPage -> {
                performReloadPage(currentState)
            }
            else -> {}
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.OnExit) {
        when (event) {
            is MainEvent.SureToExit -> {
                performReallySure(event.response)
            }
            else -> {}
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Loading) {
        when (event) {
            MainEvent.ReloadPage -> {
                performLoadPage()
            }
            else -> {}
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Search) {
        when (event) {
            is MainEvent.OnCardClicked -> {
                performItemClick(event.cardModel)
            }
            is MainEvent.SearchExit -> {
                performSearchExit(event.searchText)
            }
            else -> {}
        }
    }

    private fun performSureForExit() {
        _mainViewState.value = MainViewState.OnExit

    }

    private fun performFavLimit(){
        _mainViewState.value = MainViewState.FavLimit
    }

    private fun performItemClick(speakerModel: SpeakerItemModel) {
        _mainEffect.tryEmit(MainEffect.Navigation.ToFullView(speakerModel.id))
    }

    private fun performSearchEnter(searchText: String) {
        viewModelScope.launch {
            _mainViewState.value = MainViewState.Search(
                searchText = searchText,
                items = getAllSpeakers()?: listOf()
            )
        }
    }

    private fun performReallySure(sure: Boolean) {
        if (sure) {
            exitProcess(0)
        } else {
            performLoadPage()
        }
    }

    private fun performSearchExit(searchText: String) {
        performLoadPage(searchText)
    }

    private fun performFavoriteClick(itemId: Int, newValue: Boolean, state: MainViewState.Display) {
        val favorites = state.items.filter { it.inFav }.map { it.id }

        if (favorites.size <= 2 || !newValue){
            viewModelScope.launch {
                setInFavById(itemId, newValue)
                performLoadPage()
            }
        } else {
            performFavLimit()
        }
    }

    private fun performLoadPage(searchText: String = "") {
        viewModelScope.launch {
            if (checkIfSpeakerExists()) {
                getAllSpeakers()?.let { setDisplayData(it, searchText) }
            } else {
                getSpeakersFromRemote()
            }
        }
    }
    private fun performReloadPage(state : MainViewState.Display) {
        viewModelScope.launch {
            getSpeakersFromRemote()
        }
    }

    private suspend fun getSpeakersFromRemote(){
        deleteAllSpeakers()
        val speakers = getAllSpeakers()
        Log.d("MyLog","$speakers")
        if (speakers != null){
            saveAllSpeakers(speakers)
            setDisplayData(speakers)
        }
    }

    private suspend fun checkIfSpeakerExists(): Boolean {
        val result = (mainRepository.getSpeakerById(1) != null)
        return result
    }

    private suspend fun saveAllSpeakers(items: List<SpeakerItemModel>): Boolean {
        val result = mainRepository.saveAllSpeakers(fromAppToDataList(items))
        return result
    }

    private suspend fun getAllSpeakers(): List<SpeakerItemModel>? {
        val result = mainRepository.getAllSpeakers()?.let { fromDataToAppList(it) }
        return result
    }

    private suspend fun deleteAllSpeakers(): Boolean{
        val result = mainRepository.deleteLocalData()
        return result
    }

    private suspend fun setInFavById(id: Int, inFav: Boolean): Boolean {
        val result = mainRepository.setInFavById(id, inFav)
        return result
    }

    private fun setDisplayData(items: List<SpeakerItemModel>, searchText: String = "") {
        _mainViewState.value = MainViewState.Display(
            searchText = searchText,
            items = items,
        )
    }
}