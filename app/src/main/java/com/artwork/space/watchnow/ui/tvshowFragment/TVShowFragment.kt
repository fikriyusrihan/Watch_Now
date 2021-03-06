package com.artwork.space.watchnow.ui.tvshowFragment

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
import kotlinx.android.synthetic.main.fragment_tv_shows.*

class TVShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tv_shows, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {

            val tvShowAdapter = TVShowAdapter()
            val factory = ViewModelFactory.getInstance(requireActivity().application)
            val viewModel = ViewModelProvider(
                this,
                factory
            )[TVShowViewModel::class.java]

            viewModel.isNetworkAvailable.observe(viewLifecycleOwner, Observer { b ->
                if (b) {
                    viewModel.getPopularTVShowFromRemote()
                        .observe(viewLifecycleOwner, Observer { tvShows ->
                            viewModel.sendToDatabase(tvShows)
                        })
                }
            })

            tv_show_fragment_progress_bar.visibility = View.VISIBLE
            viewModel.popularTVShows.observe(viewLifecycleOwner, Observer { tvShows ->
                tv_show_fragment_progress_bar.visibility = View.GONE
                tvShowAdapter.submitList(tvShows)
                tvShowAdapter.notifyDataSetChanged()
            })

            with(main_tv_recycler_view) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }
}