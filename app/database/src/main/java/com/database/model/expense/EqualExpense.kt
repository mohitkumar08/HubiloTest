package com.database.model.expense

import com.database.entity.User
import com.database.model.Expense

class EqualExpense(
    userId:String,
    amount: Double,
    paidBy: User,
    expenseType: ExpenseType,
    expenseMetadata: ExpenseMetadata,
    split : List<Split>
) : Expense(userId,amount, paidBy, expenseType, expenseMetadata,split)