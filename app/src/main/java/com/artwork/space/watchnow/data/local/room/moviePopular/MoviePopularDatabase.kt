package com.artwork.space.watchnow.data.local.room.moviePopular

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artwork.space.watchnow.data.local.entity.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviePopularDatabase : RoomDatabase() {
    abstract fun moviePopularDao(): MoviePopularDao

    companion object {
        @Volatile
        private var INSTANCE: MoviePopularDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): MoviePopularDatabase {
            if (INSTANCE == null) {
                synchronized(MoviePopularDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            MoviePopularDatabase::class.java,
                            "movie_popular"
                        ).build()
                    }
                }
            }
            return INSTANCE as MoviePopularDatabase
        }
    }
}