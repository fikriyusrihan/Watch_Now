package com.artwork.space.watchnow.di

import android.content.Context
import com.artwork.space.watchnow.data.source.ApplicationRepository
import com.artwork.space.watchnow.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): ApplicationRepository {
        val remoteDataSource = RemoteDataSource()
        return ApplicationRepository(remoteDataSource)
    }
}