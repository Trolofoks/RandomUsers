package com.honey.randomusers.screens.fullinfo.model

import com.honey.randomusers.screens.main.model.SpeakerItemModel

sealed class FullViewState {
    object Loading : FullViewState()
    data class FullInfo(
        val speaker: SpeakerItemModel
    ) : FullViewState()
    data class FullScreenImage(
        val speaker: SpeakerItemModel
    ) : FullViewState()
}