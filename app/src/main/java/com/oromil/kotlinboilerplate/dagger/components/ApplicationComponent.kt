package com.oromil.kotlinboilerplate.dagger.components

import android.app.Application
import com.oromil.kotlinboilerplate.BoilerplateApp
import com.oromil.kotlinboilerplate.dagger.module.ActivityModule
import com.oromil.kotlinboilerplate.dagger.module.ApplicationModule
import com.oromil.kotlinboilerplate.data.DataManager
import com.oromil.kotlinboilerplate.ui.base.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, ActivityModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: BoilerplateApp)

    fun dataManager(): DataManager

    fun factory(): ViewModelFactory
}