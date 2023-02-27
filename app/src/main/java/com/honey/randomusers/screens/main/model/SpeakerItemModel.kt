package com.honey.randomusers.screens.main.model

import com.honey.randomusers.R

data class SpeakerItemModel(
    val id : Int = 0,
    val imageId: Int = R.drawable.img_noimg,
    val date: Int = 1,
    val timeZone: String = "??:??-??:??",
    val speaker: String = "Unknown speaker",
    val text: String = "No info",
    val inFav: Boolean = false
)