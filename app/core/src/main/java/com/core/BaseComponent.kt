package com.core

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import com.core.di.module.AppModule
import com.google.gson.Gson
import com.vmcore.VMFactoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface BaseComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): BaseComponent
    }

    fun requireContext():Context
    fun requireHandler() :Handler
    fun requireSharedPrefManager(): SharedPreferences
    fun requireGSON() :Gson

}
