package com.artwork.space.watchnow.data.local.room.moviePopular

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.artwork.space.watchnow.data.local.entity.Movie

@Dao
interface MoviePopularDao {
    @Query("DELETE FROM movie")
    fun deleteAllMovie()

    @Query("SELECT * from movie")
    fun getAllPopularMovies(): LiveData<List<Movie>>

    @Insert
    fun insertAllPopularMovie(movies: List<Movie>)

    @Transaction
    fun updatePopularMovie(movies: List<Movie>) {
        deleteAllMovie()
        insertAllPopularMovie(movies)
    }
}