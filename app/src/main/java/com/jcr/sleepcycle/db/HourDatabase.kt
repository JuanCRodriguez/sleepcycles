package com.jcr.sleepcycle.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Hour::class], version = 1)
abstract class HourDatabase : RoomDatabase() {
    abstract val hourDao: HourDao

    companion object {
        @Volatile
        private var INSTANCE: HourDatabase? = null

        fun getInstance(context: Context): HourDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HourDatabase::class.java,
                        "hours_database"
                    ).build()
                }
                return instance
            }
        }
    }
}