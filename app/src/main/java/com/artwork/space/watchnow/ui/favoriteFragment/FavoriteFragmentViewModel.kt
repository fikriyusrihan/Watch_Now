package com.artwork.space.watchnow.ui.favoriteFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.source.ApplicationRepository
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.utils.EspressoIdlingResource

class FavoriteFragmentViewModel(private val applicationRepository: ApplicationRepository) : ViewModel() {
    fun getAllFavoriteMovie() : LiveData<List<Movie>> {
        return applicationRepository.getAllFavoriteMovie()
    }
}