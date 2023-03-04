package com.honey.data.repository

import com.honey.data.intenal.mainstorage.database.MainDatabase
import com.honey.data.intenal.mainstorage.model.SpeakerItem
import com.honey.randomusers.data.MainRepository
import com.honey.randomusers.screens.main.model.SpeakerItemModel

class MainRepositoryImpl(
    //TODO(external source add)
    private val dataBase: MainDatabase
) : MainRepository{
    override suspend fun saveAllSpeakers(speakers: List<SpeakerItemModel>): Boolean {
        val speakersItems = speakers.map {speaker ->
            fromAppToData(speaker)
        }
        return dataBase.getDao().insertAllSpeakers(speakersItems)
    }

    override suspend fun getAllSpeakers(): List<SpeakerItemModel>? {
        val speakers = dataBase.getDao().getAllSpeakers()
        val speakersModel = speakers.map {speaker ->
            fromDataToApp(speaker)
        }
        return speakersModel
    }

    override suspend fun getSpeakerById(id: Int): SpeakerItemModel {
        val speaker = dataBase.getDao().getSpeakerById(id)
        //TODO("add get image from URL")
        return fromDataToApp(speaker)
    }

    private fun fromDataToApp(speaker: SpeakerItem): SpeakerItemModel{
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

    private fun fromAppToData(speaker: SpeakerItemModel): SpeakerItem{
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

}