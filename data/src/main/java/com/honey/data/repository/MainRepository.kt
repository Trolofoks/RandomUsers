package com.honey.data.repository

import com.honey.data.internal.mainstorage.database.MainDatabase
import com.honey.data.internal.mainstorage.model.SpeakerItem

class MainRepository(
    //TODO(external source add)
    private val database: MainDatabase
) {
     suspend fun saveAllSpeakers(speakers: List<SpeakerItem>): Boolean {
         val countSavedUsers = database.getDao().insertAllSpeakers(speakers)
         return (countSavedUsers.size == speakers.size)
    }

    suspend fun getAllSpeakers(): List<SpeakerItem>? {
        return database.getDao().getAllSpeakers()
    }

    suspend fun getSpeakerById(id: Int): SpeakerItem? {
        //TODO("add get image from URL")
        return database.getDao().getSpeakerById(id)
    }


}