package com.artwork.space.watchnow.ui.tvshowFragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.artwork.space.watchnow.data.ApplicationRepository
import com.artwork.space.watchnow.data.local.entity.TVShow
import com.artwork.space.watchnow.utils.DataDummy
import com.nhaarman.mockitokotlin2.atLeast
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var applicationRepository: ApplicationRepository

    @Mock
    private lateinit var observer: Observer<List<TVShow>>

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(applicationRepository)
    }

    @Test
    fun getPopularTVShowFromRemote() {
        val dummyTVShow = DataDummy.generateDummyTvShow()
        val tvShows = MutableLiveData<List<TVShow>>()
        tvShows.value = dummyTVShow

        Mockito.`when`(applicationRepository.getAllPopularTVShowFromRemote()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getPopularTVShowFromRemote().value
        verify(applicationRepository, atLeast(2)).getAllPopularTVShowFromRemote()

        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getPopularTVShowFromRemote().observeForever(observer)
        verify(observer).onChanged(dummyTVShow)

    }
}