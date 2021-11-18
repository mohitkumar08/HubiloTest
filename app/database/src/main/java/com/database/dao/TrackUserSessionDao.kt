package com.database.dao


import androidx.room.Dao
import androidx.room.Insert
import com.database.entity.TrackUserSession

@Dao
interface TrackUserSessionDao {

    @Insert
    fun addUserSession(trackUserSession: TrackUserSession): Long
}