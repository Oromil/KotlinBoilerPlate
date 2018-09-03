package com.oromil.kotlinboilerplate.dagger.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.oromil.kotlinboilerplate.data.network.Api
import com.oromil.kotlinboilerplate.dagger.ApplicationContext
import com.oromil.kotlinboilerplate.data.local.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provide application-level dependencies.
 */
@Module
class ApplicationModule(private val mApplication: Application) {

    private val DATABASE_NAME: String = "database"

    @Provides
//    @ApplicationContext
    internal fun provideApplication(): Application = mApplication

//    @ApplicationContext
    @Provides fun provideContext(): Context = mApplication.applicationContext

    @Provides
    @Singleton
    internal fun provideApiService(): Api {
        return Api.create()
    }

    @Singleton
    @Provides fun provideDataBase(context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME).build()
    }

    @Provides fun providesDao(database: AppDataBase) = database.mDao()
}