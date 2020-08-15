package com.artwork.space.watchnow.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var imageUrl: String = "",
    var title: String = "",
    var description: String = "",
    var releaseDate: String = "",
    var popularity: String = "",
    var rating: String = ""
): Parcelable