package com.artwork.space.watchnow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artwork.space.watchnow.data.source.ApplicationRepository
import com.artwork.space.watchnow.di.Injection
import com.artwork.space.watchnow.ui.detailMovieActivity.DetailMovieViewModel
import com.artwork.space.watchnow.ui.detailTVShowActivity.DetailTVShowViewModel
import com.artwork.space.watchnow.ui.movieFragment.MovieViewModel
import com.artwork.space.watchnow.ui.tvshowFragment.TVShowViewModel

class ViewModelFactory private constructor(private val applicationRepository: ApplicationRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository())
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(applicationRepository) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                TVShowViewModel(applicationRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel() as T
            }
            modelClass.isAssignableFrom(DetailTVShowViewModel::class.java) -> {
                DetailTVShowViewModel() as T
            }
            else -> throw Throwable("Unknown ViewModel class ${modelClass.name}")
        }
    }
}