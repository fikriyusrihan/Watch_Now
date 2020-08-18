package com.artwork.space.watchnow.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.artwork.space.watchnow.data.source.local.LocalDataSource
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
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ApplicationRepositoryTest {

    private val remoteDataSource = Mockito.mock(RemoteDataSource::class.java)
    private val localDataSource = Mockito.mock(LocalDataSource::class.java)
    private val moviesResponse = DataDummy.generateDummyMovie()
    private val tvShowsResponse = DataDummy.generateDummyTvShow()

    private lateinit var applicationRepository: ApplicationRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        applicationRepository = ApplicationRepository(remoteDataSource, localDataSource)
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

    @Test
    fun getAllFavoriteMovie() {
        val dummyMovie = DataDummy.generateDummyMovie()
        val movies = MutableLiveData<List<Movie>>()
        movies.value = dummyMovie

        `when`(localDataSource.getAllFavoriteMovie()).thenReturn(movies)
        val favoriteMovieEntities = applicationRepository.getAllFavoriteMovie().value
        verify(localDataSource).getAllFavoriteMovie()

        assertNotNull(favoriteMovieEntities)
        assertEquals(moviesResponse.size.toLong(), favoriteMovieEntities?.size?.toLong())
    }

    @Test
    fun getAllFavoriteTVShow() {
        val dummyTVShows = DataDummy.generateDummyTvShow()
        val tvShows = MutableLiveData<List<TVShow>>()
        tvShows.value = dummyTVShows

        `when`(localDataSource.getAllFavoriteTVShow()).thenReturn(tvShows)
        val favoriteTVShowEntities = applicationRepository.getAllFavoriteTVShow().value
        verify(localDataSource).getAllFavoriteTVShow()

        assertNotNull(favoriteTVShowEntities)
        assertEquals(tvShowsResponse.size.toLong(), favoriteTVShowEntities?.size?.toLong())
    }

}