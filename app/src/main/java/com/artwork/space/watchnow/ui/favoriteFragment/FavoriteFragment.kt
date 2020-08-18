package com.artwork.space.watchnow.ui.favoriteFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite.*


class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val movieFavoriteAdapter = MovieFavoriteAdapter()
            val tvShowFavoriteAdapter = TVShowFavoriteAdapter()

            val factory = ViewModelFactory.getInstance(requireActivity().application)
            val viewModel = ViewModelProvider(this, factory)[FavoriteFragmentViewModel::class.java]

            // Active Espresso Idling Resource when do testing
            // EspressoIdlingResource.increment()
            viewModel.getAllFavoriteMovie().observe(viewLifecycleOwner, Observer { movies ->
                movieFavoriteAdapter.setMovies(movies)
                movieFavoriteAdapter.notifyDataSetChanged()

                if (movies.isEmpty()) {
                    favorite_tv_message_no_movie.visibility = View.VISIBLE
                    favorite_recycler_view_movie.visibility = View.INVISIBLE
                } else {
                    favorite_tv_message_no_movie.visibility = View.INVISIBLE
                    favorite_recycler_view_movie.visibility = View.VISIBLE
                }
                //EspressoIdlingResource.decrement()
            })

            with(favorite_recycler_view_movie) {
                layoutManager = object : LinearLayoutManager(context) {
                    override fun canScrollVertically(): Boolean {
                        return false
                    }
                }
                setHasFixedSize(true)
                adapter = movieFavoriteAdapter
            }

            // Active Espresso Idling Resource when do testing
            // EspressoIdlingResource.increment()
            viewModel.getAllFavoriteTVShow().observe(viewLifecycleOwner, Observer { tvShows ->
                tvShowFavoriteAdapter.setTVShows(tvShows)
                tvShowFavoriteAdapter.notifyDataSetChanged()

                if (tvShows.isEmpty()) {
                    favorite_tv_message_no_tv.visibility = View.VISIBLE
                    favorite_recycler_view_tv_show.visibility = View.INVISIBLE
                } else {
                    favorite_tv_message_no_tv.visibility = View.INVISIBLE
                    favorite_recycler_view_tv_show.visibility = View.VISIBLE
                }
                //EspressoIdlingResource.decrement()
            })

            with(favorite_recycler_view_tv_show) {
                layoutManager = object : LinearLayoutManager(context) {
                    override fun canScrollVertically(): Boolean {
                        return false
                    }
                }
                setHasFixedSize(true)
                adapter = tvShowFavoriteAdapter
            }
        }
    }
}