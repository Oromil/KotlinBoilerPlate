package com.oromil.kotlinboilerplate.dagger.components

import com.oromil.kotlinboilerplate.dagger.module.ApplicationModule
import com.oromil.kotlinboilerplate.dagger.module.ViewModelModule
import com.oromil.kotlinboilerplate.data.DataManager
import com.oromil.kotlinboilerplate.ui.base.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), ViewModelModule::class])
interface ApplicationComponent {

    fun dataManager(): DataManager

    fun factory():ViewModelFactory
}