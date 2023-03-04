package com.honey.data.intenal.mainstorage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.honey.data.intenal.Constance
import com.honey.data.intenal.mainstorage.Dao

@Database(entities = [MainDatabase::class], version = 1)
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