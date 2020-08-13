package com.artwork.space.watchnow.activity.detail.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.data.TVShow
import com.artwork.space.watchnow.ui.tvshow.TVShowAdapter.Companion.EXTRA_DATA_TV
import com.artwork.space.watchnow.utils.DataDummy
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_t_v_show.*

class DetailTVShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_t_v_show)

        var intent = intent.getParcelableExtra<TVShow>(EXTRA_DATA_TV)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTVShowViewModel::class.java]

        if (intent == null) intent = DataDummy.generateDummyTvShow()[0]
        viewModel.setTVShow(intent.imageUrl)

        val entity = viewModel.getTVShow()
        val imageUrl = "https://image.tmdb.org/t/p/w500" + entity.imageUrl
        val rating = entity.rating.toFloat() / 2

        detail_tv_tv_title.text = entity.title
        detail_tv_tv_popularity.text = entity.popularity
        detail_tv_tv_description.text = entity.description
        detail_tv_tv_release_date.text = entity.releaseDate

        Glide.with(this)
            .load(imageUrl)
            .into(detail_tv_iv_poster)

        Glide.with(this)
            .load(ratingSelected(rating.toInt()))
            .into(detail_tv_iv_rating)

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