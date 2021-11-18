package com.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.database.dao.ExpenseDao
import com.database.dao.TrackUserSessionDao
import com.database.dao.UserDao
import com.database.entity.TrackUserSession
import com.database.entity.Transaction
import com.database.entity.User
import com.database.model.Expense
import com.database.model.expense.ExpenseType
import com.database.model.expense.Split
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


@Database(
    entities = [User::class, TrackUserSession::class, Expense::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class,SplitDataConverter::class)
abstract class SplitWiseDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getTrackUserSessionDao(): TrackUserSessionDao
    abstract fun getExpenseDao(): ExpenseDao
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

class SplitDataConverter {
    @TypeConverter
    fun fromSplit(value: List<Split>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Split>>() {}.type
        return gson.toJson(value, type)
    }
    @TypeConverter
    fun toSplit(value: String): List<Split> {
        val gson = Gson()
        val type = object : TypeToken<List<Split>>() {}.type
        return gson.fromJson(value, type)
    }
}


class ExpenseTypeConverter {
    @TypeConverter
    fun fromExpense(value: ExpenseType): String {
        val gson = Gson()
        val type = object : TypeToken<ExpenseType>() {}.type
        return gson.toJson(value, type)
    }
    @TypeConverter
    fun toExpense(value: String): ExpenseType {
        val gson = Gson()
        val type = object : TypeToken<ExpenseType>() {}.type
        return gson.fromJson(value, type)
    }
}

