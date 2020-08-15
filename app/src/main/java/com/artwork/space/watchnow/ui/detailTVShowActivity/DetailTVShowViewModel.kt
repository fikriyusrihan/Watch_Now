package com.artwork.space.watchnow.ui.detailTVShowActivity

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.data.source.local.entity.TVShow
import com.artwork.space.watchnow.ui.tvshowFragment.TVShowAdapter.Companion.EXTRA_DATA_TV
import com.artwork.space.watchnow.utils.DataDummy

class DetailTVShowViewModel : ViewModel() {
    private var tvShowDataDetail = MutableLiveData<TVShow>()

    private fun setTVShow(intent: Intent) {
        tvShowDataDetail.postValue(intent.getParcelableExtra(EXTRA_DATA_TV))
    }

    fun getTVShow(intent: Intent): LiveData<TVShow> {
        setTVShow(intent)

        return tvShowDataDetail
    }
}