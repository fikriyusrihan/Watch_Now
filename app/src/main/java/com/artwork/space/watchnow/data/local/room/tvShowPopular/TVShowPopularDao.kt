package com.artwork.space.watchnow.data.local.room.tvShowPopular

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.artwork.space.watchnow.data.local.entity.TVShow

@Dao
interface TVShowPopularDao {
    @Query("DELETE FROM tvshow")
    fun deleteAllTVShow()

    @Query("SELECT * from tvshow")
    fun getAllPopularTVShow(): DataSource.Factory<Int, TVShow>

    @Insert
    fun insertAllPopularTVShow(tvShows: List<TVShow>)

    @Transaction
    fun updatePopularMovie(tvShows: List<TVShow>) {
        deleteAllTVShow()
        insertAllPopularTVShow(tvShows)
    }
}