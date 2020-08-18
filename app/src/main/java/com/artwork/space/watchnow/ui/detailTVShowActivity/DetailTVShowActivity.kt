package com.artwork.space.watchnow.ui.detailTVShowActivity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_t_v_show.*

class DetailTVShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_t_v_show)

        val factory = ViewModelFactory.getInstance(application)

        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailTVShowViewModel::class.java]

        viewModel.getTVShow(intent).observe(this, Observer { entity ->
            val sharedPreferences = getSharedPreferences(entity.id, Context.MODE_PRIVATE)
            val imageUrl = "https://image.tmdb.org/t/p/w500" + entity.imageUrl
            val rating = entity.rating.toFloat() / 2

            detail_tv_btn_favorite.isChecked = sharedPreferences.getBoolean(entity.id, false)
            detail_tv_tv_title.text = entity.title
            detail_tv_tv_popularity.text = entity.popularity
            detail_tv_tv_description.text = entity.description
            detail_tv_tv_release_date.text = entity.releaseDate

            Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.placeholder_loading)
                .error(R.drawable.placeholder_broken)
                .into(detail_tv_iv_poster)

            Glide.with(this)
                .load(ratingSelected(rating.toInt()))
                .into(detail_tv_iv_rating)

            detail_tv_btn_favorite.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "Saved as Favorite", Toast.LENGTH_SHORT).show()
                    sharedPreferences.edit().putBoolean(entity.id, true).apply()
                    viewModel.addToDatabase(entity)
                } else {
                    sharedPreferences.edit().putBoolean(entity.id, false).apply()
                    Toast.makeText(this, "Deleted from Favorite", Toast.LENGTH_SHORT).show()
                    viewModel.deleteFromDatabase(entity)
                }
            }
        })

        detail_tv_btn_back.setOnClickListener { finish() }
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