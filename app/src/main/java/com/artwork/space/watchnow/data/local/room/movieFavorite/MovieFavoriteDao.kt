package com.artwork.space.watchnow.data.local.room.movieFavorite

import androidx.lifecycle.LiveData
import androidx.room.*
import com.artwork.space.watchnow.data.local.entity.Movie

@Dao
interface MovieFavoriteDao {
    @Delete
    fun delete(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Query("SELECT * from movie")
    fun getAllMovies(): LiveData<List<Movie>>
}