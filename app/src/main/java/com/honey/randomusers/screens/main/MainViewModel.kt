package com.honey.randomusers.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.honey.randomusers.screens.main.model.MainEvent
import com.honey.randomusers.screens.main.model.MainViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

//@HiltViewModel
class MainViewModel (
    //TODO(сюдя всякие репозитории передаем)
) : ViewModel() {

    var mainViewState by mutableStateOf<MainViewState>(MainViewState.Loading)
        private set

    //тут мы исходя из стейта отправляем Event(действие пользователя) куда нужно
    fun obtainEvent(event: MainEvent){
        when(mainViewState){
            is MainViewState.Display -> reduce(event, MainViewState.NoItems)
            is MainViewState.NoItems -> reduce(event, MainViewState.NoItems)
            is MainViewState.Loading -> reduce(event, MainViewState.Loading)
        }
    }

    //тут уже проверяем какое действие сделал пользователь
    private fun reduce(event: MainEvent, currentState: MainViewState.NoItems) {
        when(event){
            MainEvent.ShowHello -> performShowHello()
            else -> {}
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Display){
        when (event){
            else ->{}
        }
    }

    private fun reduce(event: MainEvent, currentState: MainViewState.Loading){
        when(event){
            else ->{}
        }
    }

    private fun performShowHello(){
        viewModelScope.launch {

        }
    }

}