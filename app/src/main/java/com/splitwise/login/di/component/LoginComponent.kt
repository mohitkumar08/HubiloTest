package com.splitwise.login.di.component

import com.core.BaseComponent
import com.core.di.scope.AppMainScope
import com.signin.data.LoginRepository
import com.splitwise.login.di.module.LoginActivityModule
import com.splitwise.login.ui.LoginActivity
import com.vmcore.VMFactoryModule
import dagger.Component

@AppMainScope
@Component(
    modules = [LoginActivityModule::class, VMFactoryModule::class],
    dependencies = [BaseComponent::class]
)
interface LoginComponent {

    @Component.Builder
    interface Builder {
        fun dependBaseComponent(baseComponent: BaseComponent): Builder
        fun build(): LoginComponent
    }

    fun inject(loginActivity: LoginActivity)
    fun getLoginRepository(): LoginRepository

}