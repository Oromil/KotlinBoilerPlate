package com.oromil.kotlinboilerplate.dagger.components

import com.oromil.kotlinboilerplate.ui.main.MainActivity
import com.oromil.kotlinboilerplate.dagger.module.ActivityModule
import com.prokofevivan.kotlinboilerplate.injection.PerActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [(ActivityModule::class)])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}