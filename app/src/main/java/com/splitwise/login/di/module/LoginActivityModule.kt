package com.splitwise.login.di.module

import androidx.lifecycle.ViewModel
import com.signin.di.module.LoginManagerModule
import com.splitwise.login.ui.LoginViewModel
import com.vmcore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module(includes = [LoginManagerModule::class])
abstract class LoginActivityModule{

        @Binds
        @IntoMap
        @ViewModelKey(LoginViewModel::class)
        abstract fun userSessionViewModel(viewModel: LoginViewModel): ViewModel
}
