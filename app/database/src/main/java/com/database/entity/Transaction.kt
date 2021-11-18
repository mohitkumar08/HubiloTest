package com.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.database.DateConverter
import java.util.*


data class Transaction(

    @ColumnInfo(name = "paid_id")
    var paidId: String,

    @ColumnInfo(name = "borrower_id")
    var borrowerId: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "amount")
    var amount: Double,

    @ColumnInfo(name = "created_at", defaultValue = "('Created at' || CURRENT_TIMESTAMP)")
    @TypeConverters(
        DateConverter::class
    )
    var createdAt: Date = Date(System.currentTimeMillis())
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var transId: Long = 0

}