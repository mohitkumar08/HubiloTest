package com.signin.di.module

import android.content.SharedPreferences
import com.core.di.scope.AppMainScope
import com.google.gson.Gson
import com.signin.data.LoginRepository
import com.signin.data.session.UserSessionManager
import com.signin.data.session.UserSessionPrefManagerImpl

import dagger.Module
import dagger.Provides

@Module
object LoginManagerModule {

    @AppMainScope
    @Provides
    internal fun provideUserSessionPref(sharedPreferences: SharedPreferences, gson: Gson): UserSessionManager
    = UserSessionPrefManagerImpl(sharedPreferences, gson)

    @AppMainScope
    @Provides
    fun provideUserSessionPref(loginSessionManager: UserSessionManager) =  LoginRepository(loginSessionManager)

}