package com.oromil.kotlinboilerplate.dagger.components

import android.app.Application
import android.content.Context
import com.oromil.kotlinboilerplate.dagger.module.ApplicationModule
import com.oromil.kotlinboilerplate.data.network.Api
import com.oromil.kotlinboilerplate.dagger.ApplicationContext
import com.oromil.kotlinboilerplate.data.DataManager
import com.oromil.kotlinboilerplate.data.local.AppDataBase
import dagger.Component
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

//    @ApplicationContext
    fun provideApplication(): Application

//    @ApplicationContext
    fun provideContext(): Context

    //    @Singleton
//    @ApplicationContext
    fun provideApiService(): Api

    fun dataManager(): DataManager

//    fun dataBase(): AppDataBase
}