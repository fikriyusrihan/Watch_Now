package com.artwork.space.watchnow.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Movie(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: String = "",

    @ColumnInfo(name = "imgUrl")
    var imageUrl: String = "",

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "release_date")
    var releaseDate: String = "",

    @ColumnInfo(name = "popularity")
    var popularity: String = "",

    @ColumnInfo(name = "rating")
    var rating: String = ""
): Parcelable