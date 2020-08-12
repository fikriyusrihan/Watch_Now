package com.artwork.space.watchnow.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.data.Movie
import com.artwork.space.watchnow.ui.movie.MovieAdapter.Companion.EXTRA_DATA
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val entity = intent.getParcelableExtra<Movie>(EXTRA_DATA)!!
        val imageUrl = "https://image.tmdb.org/t/p/w500" + entity.imageUrl
        val rating = entity.rating.toFloat() / 2

        detail_tv_title.text = entity.title
        detail_tv_popularity.text = entity.popularity
        detail_tv_description.text = entity.description
        detail_tv_release_date.text = entity.releaseDate

        Glide.with(this)
            .load(imageUrl)
            .into(detail_iv_poster)

        Glide.with(this)
            .load(ratingSelected(rating.toInt()))
            .into(detail_iv_rating)

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