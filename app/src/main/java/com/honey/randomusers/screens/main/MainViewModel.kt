package com.honey.randomusers.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.honey.randomusers.screens.main.model.MainEvent
import com.honey.randomusers.screens.main.model.MainViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //TODO(сюдя всякие репозитории передаем)
) : ViewModel() {

    var mainViewState by mutableStateOf<MainViewState>(MainViewState.Loading)
        private set

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

    private fun performShowHello(){
        viewModelScope.launch {

        }
    }

}