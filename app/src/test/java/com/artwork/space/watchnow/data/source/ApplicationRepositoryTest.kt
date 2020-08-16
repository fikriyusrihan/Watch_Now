package com.artwork.space.watchnow.data.source

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.data.source.local.entity.TVShow
import com.artwork.space.watchnow.data.source.remote.RemoteDataSource
import com.artwork.space.watchnow.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ApplicationRepositoryTest {

    private val remoteDataSource = Mockito.mock(RemoteDataSource::class.java)
    private val moviesResponse = DataDummy.generateDummyMovie()
    private val tvShowsResponse = DataDummy.generateDummyTvShow()

    private lateinit var applicationRepository: ApplicationRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var application : Application

    @Before
    fun setUp() {
        application = Application()
        applicationRepository = ApplicationRepository(remoteDataSource, application)
    }

    @Test
    fun getAllMovies() {
        val dummyMovie = DataDummy.generateDummyMovie()
        val movies = MutableLiveData<ArrayList<Movie>>()
        movies.value = dummyMovie

        `when`(remoteDataSource.getAllMovies()).thenReturn(movies)
        val movieEntities = applicationRepository.getAllMovie().value
        verify(remoteDataSource).getAllMovies()

        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size.toLong(), movieEntities?.size?.toLong())
    }

    @Test
    fun getAllTVShow() {
        val dummyTVShow = DataDummy.generateDummyTvShow()
        val tvShows = MutableLiveData<ArrayList<TVShow>>()
        tvShows.value = dummyTVShow

        `when`(remoteDataSource.getAllTVShow()).thenReturn(tvShows)
        val tvShowEntities = applicationRepository.getAllTVShow().value
        verify(remoteDataSource).getAllTVShow()

        assertNotNull(tvShowEntities)
        assertEquals(tvShowsResponse.size.toLong(), tvShowEntities?.size?.toLong())
    }

}