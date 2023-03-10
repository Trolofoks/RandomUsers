package com.honey.data.internal.mainstorage

import androidx.room.Insert
import androidx.room.Query
import com.honey.data.internal.mainstorage.model.SpeakerItem

@androidx.room.Dao
interface Dao {
    @Insert
    suspend fun insertAllSpeakers(items: List<SpeakerItem>) : List<Long>

    @Query("SELECT * FROM speakerTable")
    suspend fun getAllSpeakers() : List<SpeakerItem>?

    @Query("SELECT * FROM speakerTable WHERE id =:id")
    suspend fun getSpeakerById(id: Int) : SpeakerItem?

    @Query("DELETE FROM speakerTable")
    suspend fun deleteAllSpeakers() : Int

    @Query("UPDATE speakerTable SET inFav = :inFav WHERE id = :speakerId")
    suspend fun setFavorite(speakerId: Int, inFav : Boolean)
}