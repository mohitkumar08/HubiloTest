package com.database.di

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.database.ExpenseRepository
import com.database.ExpenseRepositoryImpl
import com.database.SplitWiseDatabase
import com.database.dao.ExpenseDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DbModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    companion object {
        private val DATABSE_NAME = "splitwise_db.db"

        private val databaseCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                Log.d("RoomDatabaseModule", "onCreate")
            }
        }

        @Singleton
        @Provides
        fun providesRoomDatabase(context: Context): SplitWiseDatabase {
            return Room.databaseBuilder(context, SplitWiseDatabase::class.java, DATABSE_NAME)
                .fallbackToDestructiveMigration()
                .addCallback(databaseCallback)
                .build()
        }

        @Singleton
        @Provides
        fun providesExpenseDAO(libraryDatabase: SplitWiseDatabase): ExpenseDao =
            libraryDatabase.getExpenseDao()

        @Singleton
        @Provides
        fun provideExpenseRepository(expenseDao: ExpenseDao): ExpenseRepository =
            ExpenseRepositoryImpl(expenseDao)
    }
}
