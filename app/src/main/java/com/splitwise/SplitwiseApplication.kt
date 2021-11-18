package com.splitwise

import android.app.Application
import com.core.BaseComponent
import com.core.DaggerBaseComponent
import com.core.di.CoreComponentProvider
import com.core.di.module.AppModule
import com.database.DBComponent
import com.database.DaggerDBComponent
import com.database.di.DbComponentProvider

class SplitwiseApplication : Application(), CoreComponentProvider, DbComponentProvider {

    private val baseComponent by lazy {
        DaggerBaseComponent.builder()
            .application(this)
            .build()
    }
    private val dbComponent by lazy {
        DaggerDBComponent.builder()
            .application(this).build()
    }

    override fun provideBaseComponent(): BaseComponent {
        return baseComponent
    }

    override fun provideDbComponent(): DBComponent {
        return  dbComponent
    }

}