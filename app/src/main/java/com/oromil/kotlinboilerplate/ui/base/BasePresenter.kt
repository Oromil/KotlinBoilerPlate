package com.oromil.kotlinboilerplate.ui.base

import javax.inject.Inject

open class BasePresenter<V : IMvpView> : IPresenter<V> {

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}