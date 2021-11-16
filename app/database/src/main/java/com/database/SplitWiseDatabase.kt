package com.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.database.dao.TrackUserSessionDao
import com.database.dao.UserDao
import com.database.entity.TrackUserSession
import com.database.entity.Users
import java.util.*


@Database(entities = [Users::class, TrackUserSession::class], version = 1,exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class SplitWiseDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getTrackUserSessionDao(): TrackUserSessionDao

}

object DateConverter {
    @TypeConverter
    fun toDate(timestamp: Long): Date {
        return Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date): Long {
        return date.time
    }
}