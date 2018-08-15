package com.oromil.kotlinboilerplate.ui.main

import android.util.Log
import com.oromil.kotlinboilerplate.data.DataManager
import com.oromil.kotlinboilerplate.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val mDataManager: DataManager) : BasePresenter<MainMvpView>() {
    override fun onViewAttached() {
        Log.d("presenter", "attached")
    }
}