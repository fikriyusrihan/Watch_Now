package com.artwork.space.watchnow.di

import android.content.Context
import com.artwork.space.watchnow.data.source.ApplicationRepository
import com.artwork.space.watchnow.data.source.local.LocalDataSource
import com.artwork.space.watchnow.data.source.local.room.movieFavorite.MovieFavoriteDatabase
import com.artwork.space.watchnow.data.source.local.room.tvShowFavorite.TVShowFavoriteDatabase
import com.artwork.space.watchnow.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): ApplicationRepository {
        val dbMovieFavoriteDao = MovieFavoriteDatabase.getDatabase(context).movieFavoriteDao()
        val dbTVShowFavoriteDao = TVShowFavoriteDatabase.getDatabase(context).tvShowFavoriteDao()

        val remoteDataSource = RemoteDataSource()
        val localDataSource = LocalDataSource(dbMovieFavoriteDao, dbTVShowFavoriteDao)
        return ApplicationRepository(remoteDataSource, localDataSource)
    }
}