package com.oromil.kotlinboilerplate.dagger.components

import com.prokofevivan.kotlinboilerplate.injection.ConfigPersistent
import com.oromil.kotlinboilerplate.dagger.module.ActivityModule
import dagger.Component

@ConfigPersistent
@Component(dependencies = [(ApplicationComponent::class)])
interface ConfigPersistentComponent {
    fun activityComponent(activityModule: ActivityModule): ActivityComponent
}
