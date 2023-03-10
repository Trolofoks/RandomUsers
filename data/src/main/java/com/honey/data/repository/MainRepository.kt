package com.honey.data.repository

import com.honey.data.external.mainstorage.MainRemoteDataSource
import com.honey.data.internal.mainstorage.database.MainLocalDataSource
import com.honey.data.internal.mainstorage.model.SpeakerItem

class MainRepository(
    private val remoteDataSource: MainRemoteDataSource,
    private val localDataSource: MainLocalDataSource
) {
     suspend fun saveAllSpeakers(speakers: List<SpeakerItem>): Boolean {
         val countSavedUsers = localDataSource.getDao().insertAllSpeakers(speakers)
         return (countSavedUsers.size == speakers.size)
    }

    suspend fun getAllSpeakers(): List<SpeakerItem>? {
        var speakers = localDataSource.getDao().getAllSpeakers()?: listOf()
        if (speakers.isEmpty()){
            speakers = remoteDataSource.getSpeakers().map {speakerModel ->
                val dayString = speakerModel.date.substring(0, speakerModel.date.indexOf(" "))
                SpeakerItem(
                    id = speakerModel.id.toInt(),
                    image = speakerModel.imageUrl,
                    date = dayString.toInt(),
                    timeZone = speakerModel.timeInterval,
                    speaker = speakerModel.speaker,
                    text = speakerModel.description,
                    inFav = speakerModel.isFavourite
                )
            }
        }
        return speakers
    }

    suspend fun getSpeakerById(id: Int): SpeakerItem? {
        return localDataSource.getDao().getSpeakerById(id)
    }

    suspend fun deleteLocalData() : Boolean {
        val deletedCount = localDataSource.getDao().deleteAllSpeakers()
        return deletedCount >= 1
    }

    suspend fun setInFavById(id: Int, inFav: Boolean) : Boolean {
        localDataSource.getDao().setFavorite(id, inFav)
        return true
    }

}