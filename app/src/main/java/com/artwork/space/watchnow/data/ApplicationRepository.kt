package com.artwork.space.watchnow.data

import androidx.lifecycle.LiveData
import com.artwork.space.watchnow.data.local.LocalDataSource
import com.artwork.space.watchnow.data.local.entity.Movie
import com.artwork.space.watchnow.data.local.entity.TVShow
import com.artwork.space.watchnow.data.remote.RemoteDataSource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApplicationRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun refreshPopularMovie(movies: List<Movie>) {
        executorService.execute { localDataSource.updateAllPopularMovie(movies) }
    }

    fun getAllPopularMovie(): LiveData<List<Movie>> {
        return localDataSource.getAllPopularMovie()
    }

    fun refreshPopularTVShow(tvShows: List<TVShow>) {
        executorService.execute { localDataSource.updateAllPopularTVShow(tvShows) }
    }

    fun getAllPopularTVShow(): LiveData<List<TVShow>> {
        return localDataSource.getAllPopularTVShow()
    }

    // Remote Repository
    fun getAllPopularMovieFromRemote(): LiveData<List<Movie>> {
        return remoteDataSource.getAllMovies()
    }

    fun getAllPopularTVShowFromRemote(): LiveData<List<TVShow>> {
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
