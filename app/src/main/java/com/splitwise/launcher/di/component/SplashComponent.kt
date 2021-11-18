package com.splitwise.launcher.di.component

import com.core.BaseComponent
import com.core.di.scope.AppMainScope
import com.signin.data.LoginRepository
import com.splitwise.launcher.SplashActivity
import com.splitwise.launcher.di.module.SplashActivityModule
import dagger.Component

@AppMainScope
@Component(
    modules = [SplashActivityModule::class],
    dependencies = [BaseComponent::class]
)
interface SplashComponent {

    @Component.Builder
    interface Builder {
        fun dependBaseComponent(baseComponent: BaseComponent): Builder
        fun build(): SplashComponent
    }

    fun inject(loginActivity: SplashActivity)
    fun getLoginRepository(): LoginRepository

}