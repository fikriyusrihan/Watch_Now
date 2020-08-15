package com.artwork.space.watchnow.data.source

import androidx.lifecycle.LiveData
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.data.source.local.entity.TVShow
import com.artwork.space.watchnow.data.source.remote.RemoteDataSource

class ApplicationRepository(private val remoteDataSource: RemoteDataSource) {
    fun getAllMovie(): LiveData<ArrayList<Movie>> {
        return remoteDataSource.getAllMovies()
    }

    fun getAllTVShow(): LiveData<ArrayList<TVShow>> {
        return remoteDataSource.getAllTVShow()
    }
}