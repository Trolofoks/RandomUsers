package com.honey.randomusers.di

import android.content.Context
import com.honey.data.external.mainstorage.MainRemoteDataSource
import com.honey.data.internal.mainstorage.database.MainLocalDataSource
import com.honey.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideMainLocalStorage(@ApplicationContext context: Context): MainLocalDataSource{
        return MainLocalDataSource.getDatabase(context = context)
    }

    @Provides
    @Singleton
    fun provideMainRemoteStorage(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGithubApi(retrofit: Retrofit): MainRemoteDataSource {
        return retrofit.create(MainRemoteDataSource::class.java)
    }

        @Provides
    @Singleton
    fun provideMainRepository(localDataSource: MainLocalDataSource, remoteDataSource: MainRemoteDataSource): MainRepository{
        return MainRepository(localDataSource = localDataSource, remoteDataSource = remoteDataSource)
    }

}


