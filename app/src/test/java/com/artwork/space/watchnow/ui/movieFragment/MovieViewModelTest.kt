package com.artwork.space.watchnow.ui.movieFragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.artwork.space.watchnow.data.ApplicationRepository
import com.artwork.space.watchnow.data.local.entity.Movie
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
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var applicationRepository: ApplicationRepository

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(applicationRepository)
    }

    @Test
    fun getPopularMovieFromRemote() {
        val dummyMovies = DataDummy.generateDummyMovie()
        val movies = MutableLiveData<List<Movie>>()
        movies.value = dummyMovies

        `when`(applicationRepository.getAllPopularMovieFromRemote()).thenReturn(movies)
        val movieEntities = viewModel.getPopularMovieFromRemote().value
        verify(applicationRepository, atLeast(2)).getAllPopularMovieFromRemote()

        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getPopularMovieFromRemote().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}