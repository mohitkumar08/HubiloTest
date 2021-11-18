package com.splitwise.transactionlist.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.core.CoreActivity
import com.core.utils.ARG_USER_ID
import com.splitwise.databinding.ActivityTransactionListBinding
import com.splitwise.expense.ui.ExpenseViewModel
import com.splitwise.login.ui.LoginActivity
import javax.inject.Inject

class TransactionListActivity : CoreActivity() {
    private lateinit var binding: ActivityTransactionListBinding


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val transactionViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(TransactionViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionListBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun setupActivityComponent() {

    }



    companion object {
        fun getIntent(context: Context,userId:String): Intent {
            return Intent(context, LoginActivity::class.java).apply {
                putExtra(ARG_USER_ID,userId)
            }
        }
    }

}