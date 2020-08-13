package com.artwork.space.watchnow.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @Before
    fun setUp() {
        viewModel = TVShowViewModel()
    }

    @Test
    fun getTVShows() {
        val tvShows = viewModel.getTVShows()
        assertNotNull(tvShows)
        assertEquals(10, tvShows.size)
    }
}