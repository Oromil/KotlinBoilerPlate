package com.oromil.kotlinboilerplate.ui.main

import com.oromil.kotlinboilerplate.ui.base.IMvpView

interface MainMvpView : IMvpView {

    fun getViewModel():MainViewModel
}