package com.honey.randomusers.screens.main.model

sealed class MainViewState {
    data class Display(
        val searchText: String = "",
        val items: List<SpeakerItemModel>,
        val favItems: List<SpeakerItemModel> = listOf()
    ): MainViewState()
    data class FullInfo(
        val item: SpeakerItemModel
    ): MainViewState()
    data class Search(
        val searchText: String,
        val items: List<SpeakerItemModel>
    ): MainViewState()
    object OnExit : MainViewState()
    object Loading : MainViewState()
    object Error : MainViewState()
}