package com.artwork.space.watchnow.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.data.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_layout.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovies = ArrayList<Movie>()

    fun setMovies(movies: List<Movie>) {
        listMovies.clear()
        listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
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
                    .into(card_image)

                Glide.with(context)
                    .load(ratingSelected(rating.toInt()))
                    .into(card_rating)

                setOnClickListener {
                    Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()
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