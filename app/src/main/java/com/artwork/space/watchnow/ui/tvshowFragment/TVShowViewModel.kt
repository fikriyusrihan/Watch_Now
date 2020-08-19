package com.artwork.space.watchnow.ui.tvshowFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.ApplicationRepository
import com.artwork.space.watchnow.data.local.entity.TVShow
import java.io.IOException

class TVShowViewModel(private val applicationRepository: ApplicationRepository) : ViewModel() {

    val popularTVShows = applicationRepository.getAllPopularTVShow()

    private var _isNetworkAvailable = MutableLiveData<Boolean>(false)

    val isNetworkAvailable: LiveData<Boolean>
        get() =_isNetworkAvailable

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        try {
            _isNetworkAvailable.value = true
            getPopularTVShowFromRemote()
        } catch (e: IOException) {
            _isNetworkAvailable.value = false
        }
    }

    fun getPopularTVShowFromRemote(): LiveData<List<TVShow>> = applicationRepository.getAllPopularTVShowFromRemote()

    fun sendToDatabase(tvShows: List<TVShow>) {
        applicationRepository.refreshPopularTVShow(tvShows)
    }
}