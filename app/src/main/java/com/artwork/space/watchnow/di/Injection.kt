package com.artwork.space.watchnow.di

import android.app.Application
import com.artwork.space.watchnow.data.source.ApplicationRepository
import com.artwork.space.watchnow.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(application: Application): ApplicationRepository {
        val remoteDataSource = RemoteDataSource()
        return ApplicationRepository(remoteDataSource, application)
    }
}