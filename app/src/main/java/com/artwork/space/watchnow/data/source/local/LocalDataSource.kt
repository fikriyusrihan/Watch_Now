package com.artwork.space.watchnow.data.source.local

import androidx.lifecycle.LiveData
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.data.source.local.entity.TVShow
import com.artwork.space.watchnow.data.source.local.room.movieFavorite.MovieFavoriteDao
import com.artwork.space.watchnow.data.source.local.room.tvShowFavorite.TVShowFavoriteDao

class LocalDataSource(
    private val movieDao: MovieFavoriteDao,
    private val tvshowDao: TVShowFavoriteDao
) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieFavoriteDao, tvshowDao: TVShowFavoriteDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao, tvshowDao)
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