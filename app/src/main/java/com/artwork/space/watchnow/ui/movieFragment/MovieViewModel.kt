package com.artwork.space.watchnow.ui.movieFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.ApplicationRepository
import com.artwork.space.watchnow.data.local.entity.Movie
import java.io.IOException

class MovieViewModel(private val applicationRepository: ApplicationRepository) : ViewModel() {
    val popularMovies = applicationRepository.getAllPopularMovie()

    private var _isNetworkAvailable = MutableLiveData<Boolean>(false)

    val isNetworkAvailable: LiveData<Boolean>
        get() = _isNetworkAvailable

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        try {
            _isNetworkAvailable.value = true
            getPopularMovieFromRemote()
        } catch (e: IOException) {
            _isNetworkAvailable.value = false
        }
    }

    fun getPopularMovieFromRemote(): LiveData<List<Movie>> = applicationRepository.getAllPopularMovieFromRemote()

    fun sendToDatabase(movies: List<Movie>) {
        applicationRepository.refreshPopularMovie(movies)
    }
}