package com.honey.randomusers.screens.fullinfo

import androidx.lifecycle.ViewModel
import com.honey.data.repository.MainRepository
import com.honey.randomusers.R
import com.honey.randomusers.screens.fullinfo.model.FullEvent
import com.honey.randomusers.screens.fullinfo.model.FullViewState
import com.honey.randomusers.screens.main.model.MainViewState
import com.honey.randomusers.screens.main.model.SpeakerItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FullInfoViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel(){

    private val _fullViewState = MutableStateFlow<FullViewState>(FullViewState.Loading)
    val fullViewState: StateFlow<FullViewState> = _fullViewState.asStateFlow()

    private val item = SpeakerItemModel(
        id = 0,
        imageId = R.drawable.img_man_one,
        date = 3,
        timeZone = "20:30 - 21:00",
        speaker = "Hello World",
        text = "Test: text text text text text text text text text text text text text text text text text text text text text text text text text text text text"
    )

    fun obtainEvent(event: FullEvent){
        when(fullViewState.value){
            is FullViewState.Loading -> reduce(event, fullViewState.value as FullViewState.Loading)
            is FullViewState.FullInfo -> reduce(event, fullViewState.value as FullViewState.FullInfo)
            is FullViewState.FullScreenImage -> reduce(event, fullViewState.value as FullViewState.FullScreenImage)
        }
    }

    private fun reduce(event: FullEvent, currentState: FullViewState.Loading){
        when(event){
            is FullEvent.OnBackPress -> {

            }
            else -> {}
        }
    }

    private fun reduce(event: FullEvent, currentState: FullViewState.FullInfo){
        when (event) {
            is FullEvent.OnBackPress -> {

            }
            else -> {}
        }
    }

    private fun reduce(event: FullEvent, currentState: FullViewState.FullScreenImage){
        when(event){
            is FullEvent.OnBackPress -> {

            }
            else -> {}
        }
    }
}