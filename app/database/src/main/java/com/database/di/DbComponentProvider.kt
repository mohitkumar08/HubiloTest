package com.database.di

import com.database.DBComponent


interface DbComponentProvider {
    fun provideDbComponent(): DBComponent
}