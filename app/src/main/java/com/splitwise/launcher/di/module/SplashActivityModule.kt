package com.splitwise.launcher.di.module

import com.signin.di.module.LoginManagerModule
import dagger.Module

@Module(includes = [LoginManagerModule::class])
abstract class SplashActivityModule{

}
