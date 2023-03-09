package com.honey.data.external.mainstorage

import retrofit2.http.GET

interface MainRemoteDataSource {
    @GET(Endpoints.GET_SPEAKERS)
    suspend fun getSpeakers(): List<SpeakerModel>
}