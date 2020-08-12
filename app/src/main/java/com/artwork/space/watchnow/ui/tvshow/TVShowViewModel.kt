package com.artwork.space.watchnow.ui.tvshow

import androidx.lifecycle.ViewModel
import com.artwork.space.watchnow.utils.DataDummy

class TVShowViewModel : ViewModel() {
    fun getTVShows() = DataDummy.generateDummyTvShow()
}