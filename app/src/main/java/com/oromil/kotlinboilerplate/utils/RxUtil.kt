package com.oromil.kotlinboilerplate.utils

import io.reactivex.disposables.Disposable

class RxUtil {

    companion object {
        fun dispose(disposable: Disposable) {
            if (!disposable.isDisposed)
                disposable.dispose()
        }
    }
}