package com.artwork.space.watchnow.ui.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.data.Movie
import com.artwork.space.watchnow.data.TVShow
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_layout.view.*

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {

    private var listTVShow = ArrayList<TVShow>()

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
                    Toast.makeText(context, tvShow.title, Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun ratingSelected(rating: Int): Int {
            return if (rating == 1) {
                R.drawable.one_star
            } else if (rating == 2) {
                R.drawable.two_star
            } else if (rating == 3) {
                R.drawable.three_star
            } else if (rating == 4) {
                R.drawable.four_star
            } else {
                R.drawable.five_star
            }
        }

    }




}