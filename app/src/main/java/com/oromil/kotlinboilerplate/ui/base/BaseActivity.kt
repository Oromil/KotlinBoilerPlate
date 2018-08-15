package com.oromil.kotlinboilerplate.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.oromil.kotlinboilerplate.BoilerplateApp
import com.oromil.kotlinboilerplate.dagger.components.ActivityComponent
import com.oromil.kotlinboilerplate.dagger.components.ConfigPersistentComponent
import com.oromil.kotlinboilerplate.dagger.components.DaggerConfigPersistentComponent
import com.oromil.kotlinboilerplate.dagger.module.ActivityModule
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject

abstract class BaseActivity<in V : IMvpView, P : IPresenter<V>, M:ViewModel>
    : AppCompatActivity(), IMvpView {

    private val KEY_ACTIVITY_ID: String = "ACTIVITY_ID"
    private val NEXT_ID: AtomicLong = AtomicLong(0)

    private val componentsMap: MutableMap<Long, ConfigPersistentComponent> = HashMap()
    private lateinit var mActivityComponent: ActivityComponent
    private var activityId: Long = NEXT_ID.get()

    @Inject protected lateinit var mPresenter: P
    protected lateinit var mViewModel: M

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createActivityComponent(savedInstanceState)
        onComponentCreated(mActivityComponent)

        setContentView(getLayoutId())

        mViewModel = ViewModelProviders.of(this).get(getViewModelClass())

        mPresenter.attachView(this as V)
        initViews()

    }

    private fun createActivityComponent(savedInstanceState: Bundle?) {
        activityId = savedInstanceState?.getLong(KEY_ACTIVITY_ID) ?: NEXT_ID.getAndIncrement()

        val configPersistentComponent: ConfigPersistentComponent
        if (!componentsMap.containsKey(activityId)) {
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .applicationComponent(BoilerplateApp.get(this).component).build()
            componentsMap[activityId] = configPersistentComponent
        } else {
            configPersistentComponent = componentsMap[activityId]!!
        }
        mActivityComponent = configPersistentComponent.activityComponent(ActivityModule(this))
    }

    protected abstract fun onComponentCreated(component: ActivityComponent)


    protected abstract fun getLayoutId(): Int

    protected abstract fun getViewModelClass():Class<M>

    protected open fun initViews() {}

    override fun onDestroy() {
        mPresenter.detachView()
        if (!isChangingConfigurations) {
            componentsMap.remove(activityId)
        }
        super.onDestroy()
    }
}