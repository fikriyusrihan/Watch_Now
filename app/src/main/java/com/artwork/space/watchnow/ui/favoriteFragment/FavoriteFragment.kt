package com.artwork.space.watchnow.ui.favoriteFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.artwork.space.watchnow.R
import com.artwork.space.watchnow.utils.EspressoIdlingResource
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
            val favoriteAdapter = FavoriteAdapter()

            val factory = ViewModelFactory.getInstance(requireActivity().application)
            val viewModel = ViewModelProvider(this, factory)[FavoriteFragmentViewModel::class.java]

            //EspressoIdlingResource.increment()
            viewModel.getAllFavoriteMovie().observe(viewLifecycleOwner, Observer { movies ->
                favoriteAdapter.setMovies(movies)
                favoriteAdapter.notifyDataSetChanged()
                //EspressoIdlingResource.decrement()
            })

            with(favorite_recycler_view) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteAdapter
            }
        }
    }
}