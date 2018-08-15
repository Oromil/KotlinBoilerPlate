package com.oromil.kotlinboilerplate.ui.main

import android.util.Log
import com.oromil.kotlinboilerplate.R
import com.oromil.kotlinboilerplate.dagger.components.ActivityComponent
import com.oromil.kotlinboilerplate.ui.base.BaseActivity

class MainActivity : BaseActivity<MainMvpView, MainPresenter, MainViewModel>() {

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onComponentCreated(component: ActivityComponent) {
        component.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViews() {
        Log.d("", "")
    }
}
