package com.artwork.space.watchnow.data.source

import androidx.lifecycle.LiveData
import com.artwork.space.watchnow.data.source.local.LocalDataSource
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.data.source.local.entity.TVShow
import com.artwork.space.watchnow.data.source.remote.RemoteDataSource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApplicationRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()


    // Remote Repository
    fun getAllMovie(): LiveData<ArrayList<Movie>> {
        return remoteDataSource.getAllMovies()
    }

    fun getAllTVShow(): LiveData<ArrayList<TVShow>> {
        return remoteDataSource.getAllTVShow()
    }


    // Local Movie Favorite Database
    fun getAllFavoriteMovie(): LiveData<List<Movie>> {
        return localDataSource.getAllFavoriteMovie()
    }

    fun deleteFavoriteMovie(movie: Movie) {
        executorService.execute { localDataSource.deleteFavoriteMovie(movie) }
    }

    fun addMovieToDatabase(movie: Movie) {
        executorService.execute { localDataSource.addMovieToDatabase(movie) }
    }


    // Local TVShow Favorite Database
    fun getAllFavoriteTVShow(): LiveData<List<TVShow>> {
        return localDataSource.getAllFavoriteTVShow()
    }

    fun deleteFavoriteTVShow(tvShow: TVShow) {
        executorService.execute { localDataSource.deleteFavoriteTVShow(tvShow) }
    }

    fun addTVShowToDatabase(tvShow: TVShow) {
        executorService.execute { localDataSource.addTVShowToDatabase(tvShow) }
    }
}