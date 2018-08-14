package com.oromil.kotlinboilerplate.ui.base

open class BasePresenter<V : IMvpView> : IPresenter<V>{

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}