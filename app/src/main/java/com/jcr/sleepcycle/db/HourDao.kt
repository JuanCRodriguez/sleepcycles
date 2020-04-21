package com.jcr.sleepcycle.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HourDao {

    @Insert
    suspend fun insertHour(hour: Hour)

    @Delete
    suspend fun deleteHour(hour: Hour)

    @Update
    suspend fun updateHour(hour: Hour)

    @Query("DELETE FROM previous_selected_hours")
    suspend fun deleteAll()

    @Query("SELECT * FROM previous_selected_hours")
    fun getAllHours(): LiveData<List<Hour>>
}