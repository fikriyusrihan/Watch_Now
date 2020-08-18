package com.artwork.space.watchnow.data.source.local.room.tvShowFavorite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artwork.space.watchnow.data.source.local.entity.TVShow

@Database(entities = [TVShow::class], version = 1)
abstract class TVShowFavoriteDatabase : RoomDatabase() {
    abstract fun tvShowFavoriteDao(): TVShowFavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: TVShowFavoriteDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): TVShowFavoriteDatabase {
            if (INSTANCE == null) {
                synchronized(TVShowFavoriteDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            TVShowFavoriteDatabase::class.java,
                            "tv_favorite"
                        ).build()
                    }
                }
            }
            return INSTANCE as TVShowFavoriteDatabase
        }
    }
}