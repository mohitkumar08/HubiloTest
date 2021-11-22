package com.splitwise.transactionlist.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.core.BaseComponent
import com.core.CoreActivity
import com.core.utils.ARG_USER_ID
import com.database.DBComponent
import com.database.entity.User
import com.splitwise.databinding.ActivityTransactionListBinding
import com.splitwise.expense.di.component.DaggerExpenseComponent
import com.splitwise.expense.ui.ExpenseViewModel
import com.splitwise.login.ui.LoginActivity
import com.splitwise.transactionlist.di.DaggerTransactionListComponent
import javax.inject.Inject

class TransactionListActivity : CoreActivity() {
    private lateinit var binding: ActivityTransactionListBinding


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var userId:String = ""

    private val transactionViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(TransactionViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent?.getStringExtra(ARG_USER_ID)?.let {
            userId = it
        }
        transactionViewModel.expenseLiveData.observe(this, {

        })

        transactionViewModel.getExpenses(userId)
    }

    override fun setupActivityComponent() {
        DaggerTransactionListComponent.builder()
            .dependBaseComponent(applicationContext as BaseComponent)
            .dependDbComponent(applicationContext as DBComponent)
            .build()
            .inject(this)
    }



    companion object {
        fun getIntent(context: Context,userId:String): Intent {
            return Intent(context, LoginActivity::class.java).apply {
                putExtra(ARG_USER_ID,userId)
            }
        }
    }

}