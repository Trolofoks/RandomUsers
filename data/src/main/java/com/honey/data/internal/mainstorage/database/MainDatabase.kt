package com.honey.data.internal.mainstorage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.honey.data.internal.Constance
import com.honey.data.internal.mainstorage.Dao
import com.honey.data.internal.mainstorage.model.SpeakerItem

@Database(entities = [SpeakerItem::class], version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{
        fun getDatabase(context: Context): MainDatabase{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDatabase::class.java,
                Constance.Name.DATABASE
            ).build()
        }
    }
}