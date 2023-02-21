package com.honey.randomusers.example.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class KittenViewState(
    val count: Int = 3
)

class Kitten3ViewModel : ViewModel() {

    private val _kitten3State = MutableStateFlow<KittenViewState>(KittenViewState())
    val kitten3State : StateFlow<KittenViewState> = _kitten3State.asStateFlow()

    fun releaseNewKittens(){

        _kitten3State.value = kitten3State.value.copy(
            count = kitten3State.value.count + 10
        )

    }
}