package com.splitwise.expense.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.core.BaseComponent
import com.core.CoreActivity
import com.core.utils.ARG_USER_ID
import com.database.DBComponent
import com.database.entity.User
import com.database.model.expense.ExpenseType
import com.splitwise.R
import com.splitwise.databinding.ActivityAddExpenceBinding
import com.splitwise.expense.di.component.DaggerExpenseComponent
import javax.inject.Inject


class AddExpenseActivity : CoreActivity() {
    private lateinit var binding: ActivityAddExpenceBinding
    private val expenseType = ExpenseType.EQUAL
    private val splitUserList = mutableListOf<User>()
    private var userId:String = ""

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val expenseViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ExpenseViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Add expense"
        intent?.getStringExtra(ARG_USER_ID)?.let {
            userId = it
            splitUserList.add(User(userId = it))
        }

    }

    override fun setupActivityComponent() {
        DaggerExpenseComponent.builder()
            .dependBaseComponent(applicationContext as BaseComponent)
            .dependDbComponent(applicationContext as DBComponent)
            .build()
            .inject(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.add_expense_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.done) {
            addExpense()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addExpense() {
        with(binding) {
            if (name.text.toString().isBlank()) {
                return@with
            }

            if (description.text.toString().isBlank()) {
                return@with
            }

            if (amount.text.toString().isBlank() || amount.text.toString().toDouble() <= 0) {
                return@with
            }
            splitUserList.add(1, User(userId = name.text.toString()))

            expenseViewModel.addExpense(
                userId,
                description.text.toString(),
                amount.text.toString().toDouble(),
                expenseType,
                splitUserList
            ) {
                val resultIntent = Intent()
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}