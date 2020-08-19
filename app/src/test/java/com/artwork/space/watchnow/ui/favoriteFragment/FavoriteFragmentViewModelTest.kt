package com.artwork.space.watchnow.ui.favoriteFragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.artwork.space.watchnow.data.ApplicationRepository
import com.artwork.space.watchnow.data.local.entity.Movie
import com.artwork.space.watchnow.data.local.entity.TVShow
import com.artwork.space.watchnow.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteFragmentViewModelTest {
    private lateinit var viewModel: FavoriteFragmentViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var applicationRepository: ApplicationRepository

    @Mock
    private lateinit var observerMovie: Observer<List<Movie>>

    @Mock
    private lateinit var observerTVShow: Observer<List<TVShow>>

    @Before
    fun setUp() {
        viewModel = FavoriteFragmentViewModel(applicationRepository)
    }

    @Test
    fun getAllFavoriteMovie() {
        val dummyMovies = DataDummy.generateDummyMovie()
        val movies = MutableLiveData<List<Movie>>()
        movies.value = dummyMovies

        `when`(applicationRepository.getAllFavoriteMovie()).thenReturn(movies)
        val moviesEntities = viewModel.getAllFavoriteMovie().value
        verify(applicationRepository).getAllFavoriteMovie()

        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        viewModel.getAllFavoriteMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovies)
    }

    @Test
    fun getAllFavoriteTVShow() {
        val dummyTVShow = DataDummy.generateDummyTvShow()
        val tvShows = MutableLiveData<List<TVShow>>()
        tvShows.value = dummyTVShow

        `when`(applicationRepository.getAllFavoriteTVShow()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getAllFavoriteTVShow().value
        verify(applicationRepository).getAllFavoriteTVShow()

        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getAllFavoriteTVShow().observeForever(observerTVShow)
        verify(observerTVShow).onChanged(dummyTVShow)
    }
}