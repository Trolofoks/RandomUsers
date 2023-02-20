package com.honey.randomusers.screens.main.model

sealed class MainViewState {
    data class Display(
        val items: List<String>
    ): MainViewState()
    object NoItems : MainViewState()
    object Loading : MainViewState()
}