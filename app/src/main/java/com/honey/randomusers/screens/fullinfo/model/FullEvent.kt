package com.honey.randomusers.screens.fullinfo.model

sealed class FullEvent{
    data class OnGetId(val id: Int): FullEvent()
}
