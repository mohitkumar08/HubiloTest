package com.splitwise.expense.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.database.ExpenseRepository
import com.database.entity.User
import com.database.model.expense.ExpenseType

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ExpenseViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var expenseRepository: ExpenseRepository

    fun addExpense(
        userId:String,
        description: String,
        amount: Double,
        expenseType: ExpenseType,
        splitList:List<User>,
        callback: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            expenseRepository.saveExpense(
                userId,
                amount,
                expenseType,
                splitList[0],
                description, splitList)
            callback.invoke()
        }
    }
}