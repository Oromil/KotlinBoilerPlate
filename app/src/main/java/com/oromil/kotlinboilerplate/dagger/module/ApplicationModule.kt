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
class ApplicationModule(protected val mApplication: Application) {

    private val DATABASE_NAME: String = "database"

    @Provides
    @ApplicationContext
    internal fun provideApplication(): Application {
        return mApplication
    }

//    @Provides
//    @ApplicationContext
//    internal fun provideContext(): Context {
//        return mApplication
//    }

    @Provides
    @Singleton
//    @ApplicationContext
    internal fun provideApiService(): Api {
        return Api.create()
    }

    @Provides
    @Singleton
    internal fun provideDataBase(): AppDataBase {
        return Room.databaseBuilder(mApplication, AppDataBase::class.java, DATABASE_NAME).build()
    }
}