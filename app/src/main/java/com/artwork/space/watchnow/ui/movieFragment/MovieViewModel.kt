package com.artwork.space.watchnow.ui.movieFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.source.ApplicationRepository
import com.artwork.space.watchnow.data.source.local.entity.Movie

class MovieViewModel(private val applicationRepository: ApplicationRepository) : ViewModel() {
    fun getAllMovies(): LiveData<ArrayList<Movie>> = applicationRepository.getAllMovie()
}