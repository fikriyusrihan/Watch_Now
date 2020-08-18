package com.artwork.space.watchnow.data.source.local.room.tvShowFavorite

import androidx.lifecycle.LiveData
import androidx.room.*
import com.artwork.space.watchnow.data.source.local.entity.TVShow

@Dao
interface TVShowFavoriteDao {
    @Delete
    fun delete(tvShow: TVShow)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tvShow: TVShow)

    @Query("SELECT * from tvshow")
    fun getAllTVShow(): LiveData<List<TVShow>>
}