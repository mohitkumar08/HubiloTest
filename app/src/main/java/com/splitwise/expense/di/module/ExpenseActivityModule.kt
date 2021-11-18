package com.splitwise.expense.di.module

import androidx.lifecycle.ViewModel
import com.signin.di.module.LoginManagerModule
import com.splitwise.expense.ui.ExpenseViewModel
import com.splitwise.login.ui.LoginViewModel
import com.vmcore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ExpenseActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(ExpenseViewModel::class)
    abstract fun expenseViewModel(viewModel: ExpenseViewModel): ViewModel
}
