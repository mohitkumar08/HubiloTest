package com.splitwise.transactionlist.di

import com.core.BaseComponent
import com.core.di.scope.AppMainScope
import com.database.DBComponent
import com.database.ExpenseRepository
import com.splitwise.transactionlist.ui.TransactionListActivity
import com.vmcore.VMFactoryModule
import dagger.Component

@AppMainScope
@Component(
    modules = [VMFactoryModule::class, TransactionListActivityModule::class],
    dependencies = [BaseComponent::class, DBComponent::class]
)
interface TransactionListComponent {

    @Component.Builder
    interface Builder {
        fun dependDbComponent(baseComponent: DBComponent): Builder
        fun dependBaseComponent(baseComponent: BaseComponent): Builder
        fun build(): TransactionListComponent
    }

    fun inject(transactionListActivity: TransactionListActivity)
    fun getExpenseRepository(): ExpenseRepository

}