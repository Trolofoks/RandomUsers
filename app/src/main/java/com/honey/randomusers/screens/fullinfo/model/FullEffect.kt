package com.honey.randomusers.screens.fullinfo.model

sealed class FullEffect {

    sealed class Navigation: FullEffect(){

        object Back: Navigation()
    }
}