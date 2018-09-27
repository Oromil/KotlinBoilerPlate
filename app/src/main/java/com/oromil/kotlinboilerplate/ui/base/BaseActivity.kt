package com.oromil.kotlinboilerplate.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.oromil.kotlinboilerplate.BoilerplateApp
import com.oromil.kotlinboilerplate.dagger.components.ActivityComponent
import com.oromil.kotlinboilerplate.dagger.components.DaggerActivityComponent
import com.oromil.kotlinboilerplate.data.DataManager
import javax.inject.Inject

abstract class BaseActivity<M : ViewModel>
    : AppCompatActivity() {

    private lateinit var mActivityComponent: ActivityComponent

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var mViewModel: M

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createActivityComponent()
        onComponentCreated(mActivityComponent)

        setContentView(getLayoutId())

        mViewModel = ViewModelProviders.of(this, viewModelFactory)[getViewModelClass()]
        subscribeOnViewModelLiveData()

        initViews()
    }

    private fun createActivityComponent() {
        mActivityComponent = DaggerActivityComponent
                .builder()
                .applicationComponent(BoilerplateApp.get(this).component)
                .build()
    }

    protected abstract fun onComponentCreated(component: ActivityComponent)


    protected abstract fun getLayoutId(): Int

    protected abstract fun getViewModelClass(): Class<M>

    protected open fun initViews() {}

    protected abstract fun subscribeOnViewModelLiveData()


}