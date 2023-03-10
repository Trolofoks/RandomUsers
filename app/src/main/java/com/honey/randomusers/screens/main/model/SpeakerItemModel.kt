package com.honey.randomusers.screens.main.model

import com.honey.randomusers.R

data class SpeakerItemModel(
    val id : Int = 0,
    val imageId: String = "https://static.tildacdn.com/tild3432-3435-4561-b136-663134643162/photo_2021-04-16_18-.jpg",
    val date: Int = 1,
    val timeZone: String = "??:??-??:??",
    val speaker: String = "Unknown speaker",
    val text: String = "No info",
    val inFav: Boolean = false
)