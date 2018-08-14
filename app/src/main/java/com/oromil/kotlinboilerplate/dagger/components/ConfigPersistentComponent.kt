package com.oromil.kotlinboilerplate.dagger.components

import com.oromil.kotlinboilerplate.dagger.ConfigPersistent
import com.oromil.kotlinboilerplate.dagger.module.ActivityModule
import dagger.Component

@ConfigPersistent
@Component(dependencies = [(ApplicationComponent::class)])
interface ConfigPersistentComponent {
    fun activityComponent(activityModule: ActivityModule): ActivityComponent
}
