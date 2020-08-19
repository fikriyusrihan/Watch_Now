package com.artwork.space.watchnow.ui.movieFragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.data.local.entity.Movie
import com.artwork.space.watchnow.ui.detailMovieActivity.DetailMovieActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_layout.view.*

class MovieAdapter : PagedListAdapter<Movie, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            with(itemView) {
                val imageUrl = "https://image.tmdb.org/t/p/w185" + movie.imageUrl
                val rating = movie.rating.toFloat() / 2

                card_title.text = movie.title
                card_description.text = movie.description

                Glide.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder_loading)
                    .error(R.drawable.placeholder_broken)
                    .into(card_image)

                Glide.with(context)
                    .load(ratingSelected(rating.toInt()))
                    .into(card_rating)

                setOnClickListener {
                    val intent = Intent(this.context, DetailMovieActivity::class.java)
                    intent.putExtra(EXTRA_DATA, movie)
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