package com.oromil.kotlinboilerplate.ui.base

interface IPresenter<in V : IMvpView> {

    fun attachView(view: V)

    fun detachView()
}