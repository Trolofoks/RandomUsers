package com.honey.data.external.mainstorage

import com.google.gson.annotations.SerializedName

data class SpeakerModel (
        @SerializedName("date")val date: String,
        @SerializedName("description")val description: String,
        @SerializedName("id")val id : String,
        @SerializedName("imageUrl")val imageUrl: String,
        @SerializedName("isFavourite")val isFavourite: Boolean,
        @SerializedName("speaker")val speaker: String,
        @SerializedName("timeInterval")val timeInterval: String
)