package com.prokofevivan.kotlinboilerplate.injection

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity
