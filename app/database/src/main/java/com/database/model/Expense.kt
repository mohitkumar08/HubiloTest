package com.database.model

import androidx.room.*
import com.database.DateConverter
import com.database.entity.User
import com.database.model.expense.ExpenseMetadata
import com.database.model.expense.ExpenseType
import com.database.model.expense.Split
import java.util.*

@Entity(tableName = "transaction_table")
open class Expense(
    @ColumnInfo
    var userId :String,

    @ColumnInfo
    var amount :Double = 0.0,

  //  @Embedded
    @Ignore
    var paidBy: User = User(),

    @ColumnInfo
    var expenseType: ExpenseType = ExpenseType.EQUAL,

    @Embedded
    var expenseMetadata: ExpenseMetadata = ExpenseMetadata(),

    @ColumnInfo(name = "expense_split")
    var split : List<Split> = emptyList()
) {

    @ColumnInfo(name = "created_at", defaultValue = "('Created at' || CURRENT_TIMESTAMP)")
    @TypeConverters(
        DateConverter::class
    )
    var createdAt: Date = Date(System.currentTimeMillis())

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var transId: Long = 0

    @ColumnInfo(name = "paid_id")
    var paidId: String =""

    @ColumnInfo(name = "borrower_id")
    var borrowerId: String = ""

}