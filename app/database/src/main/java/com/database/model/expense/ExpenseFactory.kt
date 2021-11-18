package com.database.model.expense

import com.database.entity.User
import com.database.model.Expense
import kotlin.math.roundToInt

object ExpenseFactory {

    fun createExpense(
        userId:String,
        expenseType: ExpenseType,
        amount: Double,
        paidBy: User,
        splits: List<Split>,
        expenseMetadata: ExpenseMetadata,
        users: List<User>, ): Expense {

       // when (expenseType) {
         //   ExpenseType.EQUAL -> {
                val list = mutableListOf<Split>()
                val totalSplits: Int = users.size
                val splitAmount = (amount * 100 / totalSplits).roundToInt().toDouble() / 100.0
                users.forEach {
                    list.add(Split(it, splitAmount))
                }
                return EqualExpense(userId,amount, paidBy, expenseType, expenseMetadata, splits)
          //  }
        //}
      //  return null
    }
}