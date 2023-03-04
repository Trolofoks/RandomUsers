package com.honey.randomusers.data

import com.honey.randomusers.screens.main.model.SpeakerItemModel

interface MainRepository {
    suspend fun saveAllSpeakers(speakers: List<SpeakerItemModel>): Boolean
    suspend fun getAllSpeakers() : List<SpeakerItemModel>?
    suspend fun getSpeakerById(id: Int): SpeakerItemModel
}