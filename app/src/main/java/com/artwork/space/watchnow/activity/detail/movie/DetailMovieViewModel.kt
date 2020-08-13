package com.artwork.space.watchnow.activity.detail.movie

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.Movie
import com.artwork.space.watchnow.ui.movie.MovieAdapter.Companion.EXTRA_DATA
import com.artwork.space.watchnow.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieImgUrl: String

    fun setMovie(movieImgUrl: String) {
        this.movieImgUrl = movieImgUrl
    }

    fun getMovie() : Movie{
        lateinit var movie: Movie
        val movies = DataDummy.generateDummyMovie()

        for (movieEntity in movies) {
            if (movieEntity.imageUrl == movieImgUrl) movie = movieEntity
        }


        return movie
    }
}