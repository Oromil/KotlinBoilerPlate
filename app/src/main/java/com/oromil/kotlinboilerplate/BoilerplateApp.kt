package com.oromil.kotlinboilerplate

import android.app.Application
import android.content.Context
import com.oromil.kotlinboilerplate.dagger.components.ApplicationComponent
import com.oromil.kotlinboilerplate.dagger.components.DaggerApplicationComponent
import com.oromil.kotlinboilerplate.dagger.module.ApplicationModule

class BoilerplateApp : Application() {

    companion object {
        fun get(context: Context) = context.applicationContext as BoilerplateApp
    }
    val component: ApplicationComponent? by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}