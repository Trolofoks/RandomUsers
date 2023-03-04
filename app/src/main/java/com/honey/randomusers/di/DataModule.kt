package com.honey.randomusers.di

import android.content.Context
import com.honey.data.internal.mainstorage.database.MainDatabase
import com.honey.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideMainStorage(@ApplicationContext context: Context): MainDatabase{
        return MainDatabase.getDatabase(context = context)
    }

    @Provides
    @Singleton
    fun provideMainRepository(database: MainDatabase): MainRepository{
        return MainRepository(database = database)
    }

}


