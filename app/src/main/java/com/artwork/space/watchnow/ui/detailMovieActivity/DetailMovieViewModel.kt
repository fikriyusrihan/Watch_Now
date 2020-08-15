package com.artwork.space.watchnow.ui.detailMovieActivity

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.ui.movieFragment.MovieAdapter.Companion.EXTRA_DATA
import com.artwork.space.watchnow.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private val movieDataDetail = MutableLiveData<Movie>()

    private fun setMovie(intent: Intent) {
        movieDataDetail.postValue(intent.getParcelableExtra(EXTRA_DATA))
    }

    fun getMovie(intent: Intent): LiveData<Movie> {
        setMovie(intent)

        return movieDataDetail
    }
}