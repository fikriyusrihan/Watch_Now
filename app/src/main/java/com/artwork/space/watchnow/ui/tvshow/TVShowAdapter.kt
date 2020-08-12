package com.artwork.space.watchnow.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.activity.detail.tvshow.DetailTVShowActivity
import com.artwork.space.watchnow.data.TVShow
import com.artwork.space.watchnow.ui.movie.MovieAdapter.Companion.EXTRA_DATA
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_layout.view.*

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {

    private var listTVShow = ArrayList<TVShow>()

    companion object {
        const val EXTRA_DATA_TV = "EXTRA_DATA_TV"
    }

    fun setTVShow(tvShows: List<TVShow>) {
        listTVShow.clear()
        listTVShow.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return TVShowViewHolder(view)
    }

    override fun getItemCount(): Int = listTVShow.size

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvShow = listTVShow[position]
        holder.bind(tvShow)
    }

    class TVShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TVShow) {
            with(itemView) {
                val imageUrl = "https://image.tmdb.org/t/p/w185" + tvShow.imageUrl
                val rating = tvShow.rating.toFloat() / 2

                card_title.text = tvShow.title
                card_description.text = tvShow.description

                Glide.with(context)
                    .load(imageUrl)
                    .into(card_image)

                Glide.with(context)
                    .load(ratingSelected(rating.toInt()))
                    .into(card_rating)

                setOnClickListener {
                    val intent = Intent(this.context, DetailTVShowActivity::class.java)
                    intent.putExtra(EXTRA_DATA_TV, tvShow)
                    this.context.startActivity(intent)
                }
            }
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


}