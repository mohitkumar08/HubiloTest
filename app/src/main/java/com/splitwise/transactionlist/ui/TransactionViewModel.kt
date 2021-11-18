package com.splitwise.transactionlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.database.ExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.AbstractMap
import java.util.stream.Collectors
import javax.inject.Inject


class TransactionViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var expenseRepository: ExpenseRepository

    fun getExpenses(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            expenseRepository.getAllExpenses(userId).collectLatest {

            }

        }
    }
}