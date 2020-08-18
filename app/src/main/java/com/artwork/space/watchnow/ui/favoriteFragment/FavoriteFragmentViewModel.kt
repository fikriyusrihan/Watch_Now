package com.artwork.space.watchnow.ui.favoriteFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.source.ApplicationRepository
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.data.source.local.entity.TVShow

class FavoriteFragmentViewModel(private val applicationRepository: ApplicationRepository) :
    ViewModel() {
    fun getAllFavoriteMovie(): LiveData<List<Movie>> {
        return applicationRepository.getAllFavoriteMovie()
    }

    fun getAllFavoriteTVShow(): LiveData<List<TVShow>> {
        return applicationRepository.getAllFavoriteTVShow()
    }
}