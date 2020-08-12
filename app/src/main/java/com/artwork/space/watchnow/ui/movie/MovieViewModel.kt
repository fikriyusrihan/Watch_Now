package com.artwork.space.watchnow.ui.movie

import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies() = DataDummy.generateDummyMovie()
}