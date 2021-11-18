package com.database.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.database.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllBooks(): LiveData<List<User>>
}