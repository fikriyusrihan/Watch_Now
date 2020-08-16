package com.artwork.space.watchnow.ui.detailMovieActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val factory = ViewModelFactory.getInstance(application)

        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailMovieViewModel::class.java]

        viewModel.getMovie(intent).observe(this, Observer { entity ->
            val imageUrl = "https://image.tmdb.org/t/p/w500" + entity.imageUrl
            val rating = entity.rating.toFloat().div(2)

            detail_movie_tv_title.text = entity.title
            detail_movie_tv_popularity.text = entity.popularity
            detail_movie_tv_description.text = entity.description
            detail_movie_tv_release_date.text = entity.releaseDate

            Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.placeholder_loading)
                .error(R.drawable.placeholder_broken)
                .into(detail_movie_iv_poster)

            Glide.with(this)
                .load(ratingSelected(rating.toInt()))
                .into(detail_movie_iv_rating)
        })

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