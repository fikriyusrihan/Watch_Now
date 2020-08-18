package com.artwork.space.watchnow.ui.favoriteFragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.ui.detailMovieActivity.DetailMovieActivity
import com.artwork.space.watchnow.ui.movieFragment.MovieAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_layout.view.*

class MovieFavoriteAdapter : RecyclerView.Adapter<MovieFavoriteAdapter.FavoriteViewHolder>() {

    private var listMovies = ArrayList<Movie>()

    fun setMovies(movies: List<Movie>) {
        listMovies.clear()
        listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
                    intent.putExtra(MovieAdapter.EXTRA_DATA, movie)
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