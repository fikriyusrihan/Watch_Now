package com.artwork.space.watchnow.di

import android.content.Context
import com.artwork.space.watchnow.data.ApplicationRepository
import com.artwork.space.watchnow.data.local.LocalDataSource
import com.artwork.space.watchnow.data.local.room.movieFavorite.MovieFavoriteDatabase
import com.artwork.space.watchnow.data.local.room.moviePopular.MoviePopularDatabase
import com.artwork.space.watchnow.data.local.room.tvShowFavorite.TVShowFavoriteDatabase
import com.artwork.space.watchnow.data.local.room.tvShowPopular.TVShowPopularDatabase
import com.artwork.space.watchnow.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): ApplicationRepository {
        val dbMovieFavoriteDao = MovieFavoriteDatabase.getDatabase(context).movieFavoriteDao()
        val dbTVShowFavoriteDao = TVShowFavoriteDatabase.getDatabase(context).tvShowFavoriteDao()
        val dbMoviePopularDao = MoviePopularDatabase.getDatabase(context).moviePopularDao()
        val dbTVShowPopularDao = TVShowPopularDatabase.getDatabase(context).tvShowPopularDao()

        val remoteDataSource = RemoteDataSource()
        val localDataSource = LocalDataSource(dbMovieFavoriteDao, dbTVShowFavoriteDao, dbMoviePopularDao, dbTVShowPopularDao)
        return ApplicationRepository(
            remoteDataSource,
            localDataSource
        )
    }
}