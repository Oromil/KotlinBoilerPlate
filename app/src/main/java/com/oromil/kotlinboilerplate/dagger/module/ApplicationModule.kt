package com.oromil.kotlinboilerplate.dagger.module

import android.app.Application
import android.content.Context
import com.prokofevivan.kotlinboilerplate.injection.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * Provide application-level dependencies.
 */
@Module
class ApplicationModule(protected val mApplication: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }

//    @Provides
//    @Singleton
//    internal fun provideApiService() : ApiInterface {
//        return ApiInterface.create()
//    }
}