package com.honey.randomusers.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.honey.data.repository.MainRepository
import com.honey.randomusers.R
import com.honey.randomusers.extensions.data.fromAppToDataList
import com.honey.randomusers.extensions.data.fromDataToAppList
import com.honey.randomusers.screens.main.model.MainEvent
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.model.SpeakerItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.exitProcess

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _mainViewState = MutableStateFlow<MainViewState>(MainViewState.Loading)
    val mainViewState: StateFlow<MainViewState> = _mainViewState

    private val favorites = arrayListOf<SpeakerItemModel>()

    private val hardCodeDataList = listOf(
        SpeakerItemModel(
            id = 0,
            imageId = (R.drawable.img_man_one),
            date = 5,
            timeZone = "20:00 - 21:00",
            speaker = "Hello Speaker",
            text = "Doklad: hahahahahahahah ah ha hahahahahahahahahahahaahhahahaha hahahah",
            inFav = false
        ),
        SpeakerItemModel(
            id = 1,
            imageId = (R.drawable.img_man_two),
            date = 5,
            timeZone = "19:00 - 20:00",
            speaker = "Hello Second",
            text = "Doklad: some text some text some text some text some text some text some text some text",
            inFav = false
        ),
        SpeakerItemModel(
            id = 2,
            imageId = (R.drawable.img_man_three),
            date = 7,
            timeZone = "20:00 - 21:00",
            speaker = "Hello Third",
            text = "Doklad: just test text just test text just test text just test text just test text",
            inFav = false
        ), SpeakerItemModel(
            id = 3,
            imageId = (R.drawable.img_man_four),
            date = 7,
            timeZone = "20:00 - 21:00",
            speaker = "Hello Fourth",
            text = "Doklad: loooong wordsssss tessssst",
            inFav = false
        ), SpeakerItemModel(
            id = 4,
            imageId = (R.drawable.img_man_five),
            date = 10,
            timeZone = "20:00 - 21:00",
            speaker = "Hello Fifth",
            text = "Doklad: verrrrrrrrrrryyyyyyyy looooooooonnnngggggg wooooooordddddssssss",
            inFav = false
        )
    )

    //тут мы исходя из стейта отправляем Event(действие пользователя) куда нужно
    fun obtainEvent(event: MainEvent) {
        when (mainViewState.value) {
            is MainViewState.Display -> reduce(event, mainViewState.value as MainViewState.Display)
            is MainViewState.FullInfo -> reduce(
                event,
                mainViewState.value as MainViewState.FullInfo
            )
            is MainViewState.Loading -> reduce(event, mainViewState.value as MainViewState.Loading)
            is MainViewState.Search -> reduce(event, mainViewState.value as MainViewState.Search)
            is MainViewState.OnExit -> reduce(event, mainViewState.value as MainViewState.OnExit)
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Display) {
        when (event) {
            is MainEvent.OnCardClicked -> {
                performItemClick(event.cardModel)
            }
            is MainEvent.OnAddFavClicked -> {
                performFavoriteClick(event.itemId, event.newValue)
            }
            is MainEvent.SearchEnter -> {
                performSearchEnter(event.searchText)
            }
            is MainEvent.OnBackPress -> {
                performSureForExit()
            }
            is MainEvent.ReloadPage -> {
                performReloadPage(event)
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

    private fun reduce(event: MainEvent, currentState: MainViewState.FullInfo) {
        when (event) {
            is MainEvent.OnBackPress -> {
                performFullInfoExit()
            }
            else -> {}
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Loading) {
        when (event) {
            MainEvent.ReloadPage -> {
                performReloadPage(event)
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

    private fun performItemClick(speakerModel: SpeakerItemModel) {
        _mainViewState.value = MainViewState.FullInfo(item = speakerModel)
    }

    private fun performSearchEnter(searchText: String) {
        _mainViewState.value = MainViewState.Search(
            searchText = searchText,
            items = hardCodeDataList
        )
    }

    private fun performReallySure(sure: Boolean) {
        if (sure) {
            exitProcess(0)
        } else {
            _mainViewState.value = MainViewState.Display(
                items = hardCodeDataList,
                favItems = favorites.toList()
            )
        }
    }

    private fun performSearchExit(searchText: String) {

        _mainViewState.value = MainViewState.Display(
            searchText = searchText,
            items = hardCodeDataList,
            favItems = favorites.toList()
        )
    }

    private fun performFullInfoExit() {
        _mainViewState.value = MainViewState.Display(
            items = hardCodeDataList,
            favItems = favorites.toList()
        )
    }

    private fun performFavoriteClick(itemId: Int, newValue: Boolean) {
        val itemExists = favorites.any { it.id == itemId }
        when {
            newValue && !itemExists -> {
                if (favorites.size >= 3) {
                    Log.d("MyLog", "limit 3")
                    TODO()
                } else {
                    hardCodeDataList.find { it.id == itemId }?.let { favorites.add(it) }
                }
            }
            !newValue && itemExists -> {
                favorites.removeIf { it.id == itemId }
            }
            newValue && itemExists -> {
                Log.d("MyLog", "add but exist")
            }
            else -> {
                Log.d("MyLog", "remove but not exist")
            }
        }

        _mainViewState.value = MainViewState.Display(
            items = hardCodeDataList,
            favItems = favorites.toList()
        )
    }

    private fun performReloadPage(event: MainEvent) {
        viewModelScope.launch {
            if (checkIfSpeakerExists()) {
                getAllSpeakers()?.let { setDisplayData(it) }
            } else {
                saveAllSpeakers(hardCodeDataList)
                getAllSpeakers()?.let { setDisplayData(it) }
            }
        }
    }

    private suspend fun checkIfSpeakerExists(): Boolean {
        val result = (mainRepository.getSpeakerById(0) != null)
        Log.d("MyLog", "check speaker exist $result")
        return result
    }

    private suspend fun saveAllSpeakers(items: List<SpeakerItemModel>): Boolean {
        val result = mainRepository.saveAllSpeakers(fromAppToDataList(items))
        Log.d("MyLog", "save all speakers $result")
        return result
    }

    private suspend fun getAllSpeakers(): List<SpeakerItemModel>? {
        val result = mainRepository.getAllSpeakers()?.let { fromDataToAppList(it) }
        Log.d("MyLog", "all speakers get $result")
        return result
    }

    private fun setDisplayData(items: List<SpeakerItemModel>) {
        _mainViewState.value = MainViewState.Display(
            items = items,
            favItems = favorites.toList()
        )
    }
}