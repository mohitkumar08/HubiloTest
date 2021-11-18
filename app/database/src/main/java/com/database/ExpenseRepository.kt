package com.database

import com.database.dao.ExpenseDao
import com.database.entity.User
import com.database.model.Expense
import com.database.model.expense.ExpenseFactory
import com.database.model.expense.ExpenseMetadata
import com.database.model.expense.ExpenseType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


 internal class ExpenseRepositoryImpl @Inject constructor(val expenseDao: ExpenseDao):ExpenseRepository {
    override fun saveExpense(
        userId: String,
        amount: Double,
        expenseType: ExpenseType,
        paidBy:User,
        description: String,
        users: List<User>
    ) {
        val exp = ExpenseFactory.createExpense(userId,expenseType,amount,paidBy, emptyList(), ExpenseMetadata((description)),users).apply {
            paidId = paidBy.userId
            borrowerId = users.find { it.userId!=paidId }?.userId?:""
        }
        expenseDao.addExpense(exp)
    }

     override fun getAllExpenses(userId: String): Flow<List<Expense>> = flow {
         emit(expenseDao.getGroupAllTransaction())
     }.flowOn(Dispatchers.IO)
 }

interface ExpenseRepository  {
    fun saveExpense(
        userId: String,
        amount: Double,
        expenseType: ExpenseType,
        paidBy:User,
        description: String,
        users:List<User>)

    fun getAllExpenses(userId:String): Flow<List<Expense>>
}