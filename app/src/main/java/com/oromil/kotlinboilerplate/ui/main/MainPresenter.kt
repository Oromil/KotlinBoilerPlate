package com.oromil.kotlinboilerplate.ui.main

import com.oromil.kotlinboilerplate.data.DataManager
import com.oromil.kotlinboilerplate.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(private val mDataManager: DataManager) : BasePresenter<MainMvpView>() {
    override fun onViewAttached() {
        loadNews()
    }

    fun loadNews() {
        mDataManager.getNews()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { t ->
                    mView!!.getViewModel().setContent(t)
                }
    }
}