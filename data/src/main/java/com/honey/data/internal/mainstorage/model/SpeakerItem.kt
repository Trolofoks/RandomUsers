package com.honey.data.internal.mainstorage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.honey.data.internal.Constance

@Entity(tableName = Constance.Name.SPEAKER_TABLE)
data class SpeakerItem(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    @ColumnInfo
    val imageId: Int = 123,
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
