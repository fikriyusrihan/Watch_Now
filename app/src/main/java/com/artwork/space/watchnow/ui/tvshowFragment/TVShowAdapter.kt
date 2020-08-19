package com.artwork.space.watchnow.ui.tvshowFragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.data.local.entity.TVShow
import com.artwork.space.watchnow.ui.detailTVShowActivity.DetailTVShowActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_layout.view.*

class TVShowAdapter : PagedListAdapter<TVShow, TVShowAdapter.TVShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val EXTRA_DATA_TV = "EXTRA_DATA_TV"

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVShow>() {
            override fun areItemsTheSame(oldItem: TVShow, newItem: TVShow): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TVShow, newItem: TVShow): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return TVShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
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