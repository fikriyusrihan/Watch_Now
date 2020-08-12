package com.artwork.space.watchnow.activity.detail.movie

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.Movie
import com.artwork.space.watchnow.ui.movie.MovieAdapter.Companion.EXTRA_DATA

class DetailMovieViewModel : ViewModel() {
    private var movieDataDetail = Movie()

    private fun setMovie(intent: Intent) {
        movieDataDetail = intent.getParcelableExtra(EXTRA_DATA)!!
    }

    fun getMovie(intent: Intent) : Movie{
        setMovie(intent)

        return movieDataDetail
    }
}