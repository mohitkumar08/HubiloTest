package com.splitwise.transactionlist.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.core.di.scope.AppMainScope
import com.splitwise.expense.ui.ExpenseViewModel
import com.splitwise.transactionlist.ui.TransactionViewModel
import com.splitwise.transactionlist.ui.adapter.TransactionListAdapter
import com.vmcore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class TransactionListActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(TransactionViewModel::class)
    abstract fun expenseViewModel(viewModel: TransactionViewModel): ViewModel

    companion object{
        @AppMainScope
        @Provides
        fun provideLinearLayoutService(context: Context): LinearLayoutManager {
            return LinearLayoutManager(context)
        }

        @AppMainScope
        @Provides
        fun provideTransactionAdapter(): TransactionListAdapter = TransactionListAdapter()

    }
}