package com.oromil.kotlinboilerplate.data

import com.oromil.kotlinboilerplate.data.network.Api
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val api: Api){
}