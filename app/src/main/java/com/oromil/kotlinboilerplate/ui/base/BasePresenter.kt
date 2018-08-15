package com.oromil.kotlinboilerplate.ui.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

abstract class BasePresenter<V : IMvpView> : LifecycleObserver, IPresenter<V> {

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected abstract fun onViewAttached()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        mView = null
    }
}