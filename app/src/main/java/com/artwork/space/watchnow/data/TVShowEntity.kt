package com.artwork.space.watchnow.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TVShow(
    var imageUrl: String = "",
    var title: String = "",
    var description: String = "",
    var releaseDate: String = "",
    var popularity: String = "",
    var rating: String = ""
): Parcelable