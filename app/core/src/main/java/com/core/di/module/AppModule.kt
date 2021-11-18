package com.core.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

const val PREFERENCE_KEY = "APP_PREF"
@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    companion object {

        @Provides
        @Singleton
        fun provideMainHandler(): Handler = Handler(Looper.getMainLooper())

        @Provides
        @Singleton
        fun provideSharedPreference(context: Context): SharedPreferences =
            context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)


        @Provides
        @Singleton
        fun provideGSON(): Gson = Gson()
    }
}