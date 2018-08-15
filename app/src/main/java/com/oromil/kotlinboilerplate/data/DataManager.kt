package com.oromil.kotlinboilerplate.data

import com.oromil.kotlinboilerplate.data.network.Api
import com.oromil.kotlinboilerplate.data.network.entities.ResponseEntity
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val api: Api){

    fun getNews(): Observable<ResponseEntity> {
        return api.getNews()
    }
}