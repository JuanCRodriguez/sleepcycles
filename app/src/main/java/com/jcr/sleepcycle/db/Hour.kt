package com.jcr.sleepcycle.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "previous_selected_hours")
data class Hour(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,


    @ColumnInfo(name = "hour")
    var hour: String
)
