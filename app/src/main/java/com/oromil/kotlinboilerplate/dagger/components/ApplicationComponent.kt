package com.oromil.kotlinboilerplate.dagger.components

import android.app.Application
import android.content.Context
import com.oromil.kotlinboilerplate.BoilerplateApp
import com.oromil.kotlinboilerplate.dagger.module.ApplicationModule
import com.oromil.kotlinboilerplate.data.DataManager
import com.oromil.kotlinboilerplate.data.network.Api
import com.prokofevivan.kotlinboilerplate.injection.ApplicationContext
import dagger.Component
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    @Provides
    @ApplicationContext
    fun context(): Context

    @Provides
    @ApplicationContext
    fun application(): Application

    @Provides
    @Singleton
    fun apiService():Api
}