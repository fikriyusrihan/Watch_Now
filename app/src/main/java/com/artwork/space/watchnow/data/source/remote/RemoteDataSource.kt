package com.artwork.space.watchnow.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.artwork.space.watchnow.data.source.local.entity.Movie
import com.artwork.space.watchnow.data.source.local.entity.TVShow
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class RemoteDataSource {
    private val moviesList = MutableLiveData<ArrayList<Movie>>()
    private val tvShowsList = MutableLiveData<ArrayList<TVShow>>()

    companion object {
        const val TAG = "RemoteDataSource"
        const val API_KEY = "ba4566954a201b74b3ac6e02102ebccf"
    }

    private fun setAllMovies() {
        val movies = ArrayList<Movie>()
        val client = AsyncHttpClient()
        val url =
            "https://api.themoviedb.org/3/movie/popular?api_key=$API_KEY&language=en-US&page=1"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                try {
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    val jsonArray = responseObject.getJSONArray("results")

                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)

                        val imgUrl = jsonObject.getString("poster_path")
                        val title = jsonObject.getString("title")
                        val description = jsonObject.getString("overview")
                        val releaseDate = jsonObject.getString("release_date")
                        val popularity = jsonObject.getString("popularity")
                        val rating = jsonObject.getString("vote_average")

                        movies.add(
                            Movie(
                                imgUrl,
                                title,
                                description,
                                releaseDate,
                                popularity,
                                rating
                            )
                        )
                    }
                    moviesList.postValue(movies)

                } catch (e: Exception) {
                    Log.d(TAG, "onSuccess: ${e.message.toString()}")
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Log.d(TAG, "onFailure: ${error?.message.toString()}")
            }

        })
    }

    private fun setAllTVShow() {
        val tvShows = ArrayList<TVShow>()
        val client = AsyncHttpClient()
        val url = "https://api.themoviedb.org/3/tv/popular?api_key=$API_KEY&language=en-US&page=1"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                try {
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    val jsonArray = responseObject.getJSONArray("results")

                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)

                        val imgUrl = jsonObject.getString("poster_path")
                        val title = jsonObject.getString("name")
                        val description = jsonObject.getString("overview")
                        val releaseDate = jsonObject.getString("first_air_date")
                        val popularity = jsonObject.getString("popularity")
                        val rating = jsonObject.getString("vote_average")

                        tvShows.add(
                            TVShow(
                                imgUrl,
                                title,
                                description,
                                releaseDate,
                                popularity,
                                rating
                            )
                        )
                    }
                    tvShowsList.postValue(tvShows)

                } catch (e: Exception) {
                    Log.d(TAG, "onSuccess: ${e.message.toString()}")
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Log.d(TAG, "onFailure: ${error?.message.toString()}")
            }

        })
    }

    fun getAllMovies(): LiveData<ArrayList<Movie>> {
        setAllMovies()
        return moviesList
    }

    fun getAllTVShow(): LiveData<ArrayList<TVShow>> {
        setAllTVShow()
        return tvShowsList
    }
}