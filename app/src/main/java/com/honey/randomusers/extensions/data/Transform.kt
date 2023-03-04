package com.honey.randomusers.extensions.data

import androidx.lifecycle.ViewModel
import com.honey.data.internal.mainstorage.model.SpeakerItem
import com.honey.randomusers.screens.main.model.SpeakerItemModel

fun ViewModel.fromDataToApp(speaker: SpeakerItem): SpeakerItemModel{
    return SpeakerItemModel(
        id = speaker.id,
        imageId = speaker.imageId,
        date = speaker.date,
        timeZone = speaker.timeZone,
        speaker = speaker.speaker,
        text = speaker.text,
        inFav = speaker.inFav
    )
}
fun ViewModel.fromDataToAppList(speakers: List<SpeakerItem>): List<SpeakerItemModel> {
    return speakers.map {speaker->
        fromDataToApp(speaker)
    }
}

fun ViewModel.fromAppToData(speaker: SpeakerItemModel): SpeakerItem{
    return SpeakerItem(
        id = speaker.id,
        imageId = speaker.imageId,
        date = speaker.date,
        timeZone = speaker.timeZone,
        speaker = speaker.speaker,
        text = speaker.text,
        inFav = speaker.inFav
    )
}
fun ViewModel.fromAppToDataList(speakers: List<SpeakerItemModel>): List<SpeakerItem> {
    return speakers.map {speaker->
        fromAppToData(speaker)
    }
}