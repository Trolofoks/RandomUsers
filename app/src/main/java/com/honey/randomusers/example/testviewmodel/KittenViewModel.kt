package com.honey.randomusers.example.testviewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch



//@HiltViewModel
class KittenViewModel : ViewModel() {

    var kitten by mutableStateOf(4)
        private set

    private val _kitten2 = MutableStateFlow<Int>(5)
    val kitten2 : StateFlow<Int> = _kitten2.asStateFlow()

    fun releaseNewKittens(){

        kitten += 10
        _kitten2.value += 10
    }
}