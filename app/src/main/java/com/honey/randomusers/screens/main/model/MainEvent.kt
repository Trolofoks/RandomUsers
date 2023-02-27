package com.honey.randomusers.screens.main.model

sealed class MainEvent {
    object ShowHello : MainEvent()
    object OnBackPress: MainEvent()
    data class SureToExit(val response: Boolean): MainEvent()
    data class OnCardClicked(val cardModel: SpeakerItemModel) : MainEvent()
    data class OnAddFavClicked(val itemId: Int, val newValue: Boolean) : MainEvent()
    data class SearchEnter(val searchText: String): MainEvent()
    data class SearchExit(val searchText: String): MainEvent()
}