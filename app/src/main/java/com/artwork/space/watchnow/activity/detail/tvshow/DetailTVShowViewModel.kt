package com.artwork.space.watchnow.activity.detail.tvshow

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.TVShow
import com.artwork.space.watchnow.ui.tvshow.TVShowAdapter.Companion.EXTRA_DATA_TV
import com.artwork.space.watchnow.utils.DataDummy

class DetailTVShowViewModel: ViewModel() {
    private lateinit var tvShowImgUrl: String

    fun setTVShow(tvShowImgUrl: String) {
        this.tvShowImgUrl = tvShowImgUrl
    }

    fun getTVShow(): TVShow {
        lateinit var tvShow: TVShow
        val tvShows = DataDummy.generateDummyTvShow()

        for (tvShowEntity in tvShows) {
            if (tvShowEntity.imageUrl == tvShowImgUrl) tvShow = tvShowEntity
        }

        return tvShow
    }
}