package com.artwork.space.watchnow.data.source.local.room.movieFavorite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artwork.space.watchnow.data.source.local.entity.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieFavoriteDatabase : RoomDatabase() {
    abstract fun movieFavoriteDao(): MovieFavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: MovieFavoriteDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): MovieFavoriteDatabase {
            if (INSTANCE == null) {
                synchronized(MovieFavoriteDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            MovieFavoriteDatabase::class.java,
                            "movie_favorite"
                        ).build()
                    }
                }
            }
            return INSTANCE as MovieFavoriteDatabase
        }
    }
}