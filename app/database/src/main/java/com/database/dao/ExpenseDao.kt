package com.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.database.model.Expense

@Dao
interface ExpenseDao {
    @Insert
    fun addExpense(expense: Expense): Long

    @Query(value = "SELECT * FROM transaction_table ")
    suspend fun getAllTransaction(): List<Expense>

    @Query(value = "SELECT *, SUM(amount) FROM transaction_table  GROUP BY borrower_id ORDER BY created_at DESC")
    suspend fun getGroupAllTransaction(): List<Expense>

    @Query(value = "SELECT * FROM transaction_table where borrower_id=:borrowerId  ORDER BY created_at DESC")
    suspend fun getTransactionBorrowerId(borrowerId:String): List<Expense>
}