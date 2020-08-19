package com.artwork.space.watchnow.ui.detailMovieActivity

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.ApplicationRepository
import com.artwork.space.watchnow.data.local.entity.Movie
import com.artwork.space.watchnow.ui.movieFragment.MovieAdapter.Companion.EXTRA_DATA

class DetailMovieViewModel(private val applicationRepository: ApplicationRepository) : ViewModel() {
    private val movieDataDetail = MutableLiveData<Movie>()

    private fun setMovie(intent: Intent) {
        movieDataDetail.postValue(intent.getParcelableExtra(EXTRA_DATA))
    }

    fun getMovie(intent: Intent): LiveData<Movie> {
        setMovie(intent)

        return movieDataDetail
    }

    fun addToDatabase(movie: Movie) {
        applicationRepository.addMovieToDatabase(movie)
    }

    fun deleteFromDatabase(movie: Movie) {
        applicationRepository.deleteFavoriteMovie(movie)
    }
}