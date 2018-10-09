package com.oromil.kotlinboilerplate.dagger.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.oromil.kotlinboilerplate.data.network.Api
import com.oromil.kotlinboilerplate.data.local.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provide application-level dependencies.
 */

@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    private val DATABASE_NAME: String = "database"

    @Provides
    @Singleton
    internal fun provideApiService(): Api {
        return Api.create()
    }

    @Singleton
    @Provides
    fun provideDataBase(application: Application): AppDataBase {
        return Room.databaseBuilder(application, AppDataBase::class.java, DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun providesDao(database: AppDataBase) = database.mDao()
}