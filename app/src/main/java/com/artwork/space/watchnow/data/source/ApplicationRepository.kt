package com.artwork.space.watchnow.data.source

import android.app.Application
import androidx.lifecycle.LiveData
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.data.source.local.entity.TVShow
import com.artwork.space.watchnow.data.source.local.room.movieFavorite.MovieFavoriteDao
import com.artwork.space.watchnow.data.source.local.room.movieFavorite.MovieFavoriteDatabase
import com.artwork.space.watchnow.data.source.remote.RemoteDataSource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApplicationRepository(private val remoteDataSource: RemoteDataSource, application: Application) {
    private val movieFavoriteDao: MovieFavoriteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val dbFavoriteMovie = MovieFavoriteDatabase.getDatabase(application)
        movieFavoriteDao = dbFavoriteMovie.movieFavoriteDao()
    }

    fun getAllMovie(): LiveData<ArrayList<Movie>> {
        return remoteDataSource.getAllMovies()
    }

    fun getAllTVShow(): LiveData<ArrayList<TVShow>> {
        return remoteDataSource.getAllTVShow()
    }

    fun getAllFavoriteMovie(): LiveData<List<Movie>> {
        return movieFavoriteDao.getAllMovies()
    }

    fun deleteFavoriteMovie(movie: Movie) {
        executorService.execute { movieFavoriteDao.delete(movie) }
    }
}