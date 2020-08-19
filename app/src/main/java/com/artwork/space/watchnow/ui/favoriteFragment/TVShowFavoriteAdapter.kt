package com.artwork.space.watchnow.ui.favoriteFragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.data.local.entity.TVShow
import com.artwork.space.watchnow.ui.detailTVShowActivity.DetailTVShowActivity
import com.artwork.space.watchnow.ui.tvshowFragment.TVShowAdapter.Companion.EXTRA_DATA_TV
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_layout.view.*

class TVShowFavoriteAdapter : RecyclerView.Adapter<TVShowFavoriteAdapter.FavoriteViewHolder>() {

    private var listTVShow = ArrayList<TVShow>()

    fun setTVShows(tvShows: List<TVShow>) {
        listTVShow.clear()
        listTVShow.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTVShow.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val tvShow = listTVShow[position]
        holder.bind(tvShow)
    }

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TVShow) {
            with(itemView) {
                val imageUrl = "https://image.tmdb.org/t/p/w185" + tvShow.imageUrl
                val rating = tvShow.rating.toFloat() / 2

                card_title.text = tvShow.title
                card_description.text = tvShow.description

                Glide.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder_loading)
                    .error(R.drawable.placeholder_broken)
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