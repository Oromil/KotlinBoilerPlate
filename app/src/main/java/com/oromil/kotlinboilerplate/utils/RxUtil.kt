package com.oromil.kotlinboilerplate.utils

import io.reactivex.disposables.Disposable

fun dispose(disposable: Disposable) {
    if (!disposable.isDisposed)
        disposable.dispose()
}