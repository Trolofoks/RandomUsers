package com.honey.data.internal.mainstorage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.honey.data.internal.Constance
import com.honey.data.internal.mainstorage.Dao
import com.honey.data.internal.mainstorage.model.SpeakerItem

@Database(entities = [SpeakerItem::class], version = 1)
abstract class MainLocalDataSource : RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{
        fun getDatabase(context: Context): MainLocalDataSource{
            return Room.databaseBuilder(
                context.applicationContext,
                MainLocalDataSource::class.java,
                Constance.Name.DATABASE
            ).build()
        }
    }
}