package com.artwork.space.watchnow.ui.favoriteFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.local.entity.Movie
import com.artwork.space.watchnow.data.local.entity.TVShow
import com.artwork.space.watchnow.data.ApplicationRepository

class FavoriteFragmentViewModel(private val applicationRepository: ApplicationRepository) :
    ViewModel() {
    fun getAllFavoriteMovie(): LiveData<List<Movie>> {
        return applicationRepository.getAllFavoriteMovie()
    }

    fun getAllFavoriteTVShow(): LiveData<List<TVShow>> {
        return applicationRepository.getAllFavoriteTVShow()
    }
}