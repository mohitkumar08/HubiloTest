package com.splitwise.transaction

import android.os.Bundle
import com.core.CoreActivity
import com.splitwise.databinding.ActivityTransactionBinding

class TransactionDetailActivity : CoreActivity() {
    private lateinit var binding: ActivityTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setupActivityComponent() {
    }
}