package com.artwork.space.watchnow.data.local

import androidx.lifecycle.LiveData
import com.artwork.space.watchnow.data.local.entity.Movie
import com.artwork.space.watchnow.data.local.entity.TVShow
import com.artwork.space.watchnow.data.local.room.movieFavorite.MovieFavoriteDao
import com.artwork.space.watchnow.data.local.room.moviePopular.MoviePopularDao
import com.artwork.space.watchnow.data.local.room.tvShowFavorite.TVShowFavoriteDao
import com.artwork.space.watchnow.data.local.room.tvShowPopular.TVShowPopularDao

class LocalDataSource(
    private val movieDao: MovieFavoriteDao,
    private val tvshowDao: TVShowFavoriteDao,
    private val popularMovieDao: MoviePopularDao,
    private val popularTVShowDao: TVShowPopularDao
) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(
            movieDao: MovieFavoriteDao,
            tvshowDao: TVShowFavoriteDao,
            popularMovieDao: MoviePopularDao,
            popularTVShowDao: TVShowPopularDao
        ): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao, tvshowDao, popularMovieDao, popularTVShowDao)
    }

    fun getAllPopularMovie(): LiveData<List<Movie>> {
        return popularMovieDao.getAllPopularMovies()
    }

    fun updateAllPopularMovie(movies: List<Movie>?) {
        if (movies != null) {
            popularMovieDao.updatePopularMovie(movies)
        }
    }

    fun getAllPopularTVShow(): LiveData<List<TVShow>> {
        return popularTVShowDao.getAllPopularTVShow()
    }

    fun updateAllPopularTVShow(tvShows: List<TVShow>?) {
        if (tvShows != null) {
            popularTVShowDao.updatePopularMovie(tvShows)
        }
    }

    fun getAllFavoriteMovie(): LiveData<List<Movie>> {
        return movieDao.getAllMovies()
    }

    fun deleteFavoriteMovie(movie: Movie) {
        return movieDao.delete(movie)
    }

    fun addMovieToDatabase(movie: Movie) {
        return movieDao.insert(movie)
    }

    fun getAllFavoriteTVShow(): LiveData<List<TVShow>> {
        return tvshowDao.getAllTVShow()
    }

    fun deleteFavoriteTVShow(tvShow: TVShow) {
        return tvshowDao.delete(tvShow)
    }

    fun addTVShowToDatabase(tvShow: TVShow) {
        return tvshowDao.insert(tvShow)
    }

}