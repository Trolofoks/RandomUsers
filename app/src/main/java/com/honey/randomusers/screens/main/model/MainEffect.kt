package com.honey.randomusers.screens.main.model

sealed class MainEffect {
    sealed class Navigation: MainEffect(){
        object TestStay: Navigation()
        data class ToFullView(val speakerId: Int): Navigation()
    }
}