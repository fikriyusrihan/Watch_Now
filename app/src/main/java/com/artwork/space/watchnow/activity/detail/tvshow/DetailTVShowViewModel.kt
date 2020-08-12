package com.artwork.space.watchnow.activity.detail.tvshow

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.TVShow
import com.artwork.space.watchnow.ui.tvshow.TVShowAdapter.Companion.EXTRA_DATA_TV

class DetailTVShowViewModel: ViewModel() {
    private var tvShowDataDetail = TVShow()

    private fun setTVShow(intent: Intent) {
        tvShowDataDetail = intent.getParcelableExtra(EXTRA_DATA_TV)!!
    }

    fun getTVShow(intent: Intent): TVShow {
        setTVShow(intent)

        return tvShowDataDetail
    }
}