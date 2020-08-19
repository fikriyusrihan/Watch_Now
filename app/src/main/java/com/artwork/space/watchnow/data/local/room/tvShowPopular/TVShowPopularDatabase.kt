package com.artwork.space.watchnow.data.local.room.tvShowPopular

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artwork.space.watchnow.data.local.entity.TVShow

@Database(entities = [TVShow::class], version = 1)
abstract class TVShowPopularDatabase : RoomDatabase() {
    abstract fun tvShowPopularDao(): TVShowPopularDao

    companion object {
        @Volatile
        private var INSTANCE: TVShowPopularDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): TVShowPopularDatabase {
            if (INSTANCE == null) {
                synchronized(TVShowPopularDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            TVShowPopularDatabase::class.java,
                            "tv_show_popular"
                        ).build()
                    }
                }
            }
            return INSTANCE as TVShowPopularDatabase
        }
    }
}