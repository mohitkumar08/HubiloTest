package com.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.database.DateConverter
import java.util.*


@Entity(tableName = "track_user_session")
data class TrackUserSession(
    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "created_at", defaultValue = "('Created at' || CURRENT_TIMESTAMP)")
    @TypeConverters(
        DateConverter::class
    )
    var createdAt: Date = Date(System.currentTimeMillis())
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}