package com.artwork.space.watchnow.data.source

import android.app.Application
import androidx.lifecycle.LiveData
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.data.source.local.entity.TVShow
import com.artwork.space.watchnow.data.source.local.room.movieFavorite.MovieFavoriteDao
import com.artwork.space.watchnow.data.source.local.room.movieFavorite.MovieFavoriteDatabase
import com.artwork.space.watchnow.data.source.local.room.tvShowFavorite.TVShowFavoriteDao
import com.artwork.space.watchnow.data.source.local.room.tvShowFavorite.TVShowFavoriteDatabase
import com.artwork.space.watchnow.data.source.remote.RemoteDataSource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApplicationRepository(
    private val remoteDataSource: RemoteDataSource,
    application: Application
) {
    private val movieFavoriteDao: MovieFavoriteDao
    private val tvShowFavoriteDao: TVShowFavoriteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val dbFavoriteMovie = MovieFavoriteDatabase.getDatabase(application)
        val dbFavoriteTVShow = TVShowFavoriteDatabase.getDatabase(application)
        movieFavoriteDao = dbFavoriteMovie.movieFavoriteDao()
        tvShowFavoriteDao = dbFavoriteTVShow.tvShowFavoriteDao()
    }

    // Remote Repository
    fun getAllMovie(): LiveData<ArrayList<Movie>> {
        return remoteDataSource.getAllMovies()
    }

    fun getAllTVShow(): LiveData<ArrayList<TVShow>> {
        return remoteDataSource.getAllTVShow()
    }


    // Local Movie Favorite Database
    fun getAllFavoriteMovie(): LiveData<List<Movie>> {
        return movieFavoriteDao.getAllMovies()
    }

    fun deleteFavoriteMovie(movie: Movie) {
        executorService.execute { movieFavoriteDao.delete(movie) }
    }

    fun addMovieToDatabase(movie: Movie) {
        executorService.execute { movieFavoriteDao.insert(movie) }
    }


    // Local TVShow Favorite Database
    fun getAllFavoriteTVShow(): LiveData<List<TVShow>> {
        return tvShowFavoriteDao.getAllTVShow()
    }

    fun deleteFavoriteTVShow(tvShow: TVShow) {
        executorService.execute { tvShowFavoriteDao.delete(tvShow) }
    }

    fun addTVShowToDatabase(tvShow: TVShow) {
        executorService.execute { tvShowFavoriteDao.insert(tvShow) }
    }
}