package com.honey.data.intenal.mainstorage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.honey.randomusers.R

@Entity
data class SpeakerItem(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    @ColumnInfo
    val imageId: Int = R.drawable.img_noimg,
    @ColumnInfo
    val date: Int = 1,
    @ColumnInfo
    val timeZone: String,
    @ColumnInfo
    val speaker: String,
    @ColumnInfo
    val text: String,
    @ColumnInfo
    val inFav: Boolean = false
)
