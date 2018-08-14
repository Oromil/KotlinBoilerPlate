package com.oromil.kotlinboilerplate.dagger.module

import android.app.Activity
import android.content.Context
import com.oromil.kotlinboilerplate.dagger.ActivityContext
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    @ActivityContext
    internal fun providesContext(): Context {
        return mActivity
    }
}
