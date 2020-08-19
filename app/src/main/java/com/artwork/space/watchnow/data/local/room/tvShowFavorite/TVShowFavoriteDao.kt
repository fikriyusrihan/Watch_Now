package com.artwork.space.watchnow.data.local.room.tvShowFavorite

import androidx.lifecycle.LiveData
import androidx.room.*
import com.artwork.space.watchnow.data.local.entity.TVShow

@Dao
interface TVShowFavoriteDao {
    @Delete
    fun delete(tvShow: TVShow)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tvShow: TVShow)

    @Query("SELECT * from tvshow")
    fun getAllTVShow(): LiveData<List<TVShow>>
}