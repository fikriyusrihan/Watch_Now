package com.artwork.space.watchnow.activity.detail.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.data.Movie
import com.artwork.space.watchnow.ui.movie.MovieAdapter.Companion.EXTRA_DATA
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]
        val entity = viewModel.getMovie(intent)
        val imageUrl = "https://image.tmdb.org/t/p/w500" + entity.imageUrl
        val rating = entity.rating.toFloat() / 2

        detail_movie_tv_title.text = entity.title
        detail_movie_tv_popularity.text = entity.popularity
        detail_movie_tv_description.text = entity.description
        detail_movie_tv_release_date.text = entity.releaseDate

        Glide.with(this)
            .load(imageUrl)
            .into(detail_movie_iv_poster)

        Glide.with(this)
            .load(ratingSelected(rating.toInt()))
            .into(detail_movie_iv_rating)

        detail_movie_btn_back.setOnClickListener { finish() }
    }

    private fun ratingSelected(rating: Int): Int {
        return when (rating) {
            1 -> {
                R.drawable.one_star
            }
            2 -> {
                R.drawable.two_star
            }
            3 -> {
                R.drawable.three_star
            }
            4 -> {
                R.drawable.four_star
            }
            else -> {
                R.drawable.five_star
            }
        }
    }
}