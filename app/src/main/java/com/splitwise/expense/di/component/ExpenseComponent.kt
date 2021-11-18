package com.splitwise.expense.di.component

import com.core.BaseComponent
import com.core.di.scope.AppMainScope
import com.database.DBComponent
import com.database.ExpenseRepository
import com.splitwise.expense.di.module.ExpenseActivityModule
import com.splitwise.expense.ui.AddExpenseActivity
import com.splitwise.transactionlist.di.TransactionListActivityModule
import com.vmcore.VMFactoryModule
import dagger.Component

@AppMainScope
@Component(
    modules = [VMFactoryModule::class, ExpenseActivityModule::class],
    dependencies = [BaseComponent::class, DBComponent::class]
)
interface ExpenseComponent {

    @Component.Builder
    interface Builder {
        fun dependDbComponent(baseComponent: DBComponent): Builder
        fun dependBaseComponent(baseComponent: BaseComponent): Builder
        fun build(): ExpenseComponent
    }

    fun inject(loginActivity: AddExpenseActivity)
    fun getExpenseRepository(): ExpenseRepository

}