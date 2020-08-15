package com.artwork.space.watchnow.ui.tvshowFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.source.ApplicationRepository
import com.artwork.space.watchnow.data.source.local.entity.TVShow

class TVShowViewModel(private val applicationRepository: ApplicationRepository) : ViewModel() {
    fun getAllTVShows(): LiveData<ArrayList<TVShow>> = applicationRepository.getAllTVShow()
}