package com.oromil.kotlinboilerplate.dagger.components

import com.oromil.kotlinboilerplate.ui.main.MainActivity
import com.oromil.kotlinboilerplate.dagger.module.ActivityModule
import com.oromil.kotlinboilerplate.dagger.scopes.PerActivity
import dagger.Component

@PerActivity
@Component(modules = [(ActivityModule::class)], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}