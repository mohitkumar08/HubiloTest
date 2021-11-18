package com.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "user_id")
    var userId: String = "",

    @ColumnInfo(name = "name")
    var name: String? = null
)