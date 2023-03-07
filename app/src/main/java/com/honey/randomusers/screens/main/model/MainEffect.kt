package com.honey.randomusers.screens.main.model

sealed class MainEffect {
    sealed class Navigation: MainEffect(){
        data class ToFullView(val speakerId: Int): Navigation()
    }
}