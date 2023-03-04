package com.honey.data.intenal.mainstorage

import androidx.room.Insert
import androidx.room.Query
import com.honey.data.intenal.mainstorage.model.SpeakerItem

@androidx.room.Dao
interface Dao {
    @Insert
    suspend fun insertAllSpeakers(items: List<SpeakerItem>): Boolean

    @Query("SELECT * FROM speakeritem")
    suspend fun getAllSpeakers() : List<SpeakerItem>

    @Query("SELECT * FROM speakeritem WHERE id =:id")
    suspend fun getSpeakerById(id: Int) : SpeakerItem


}