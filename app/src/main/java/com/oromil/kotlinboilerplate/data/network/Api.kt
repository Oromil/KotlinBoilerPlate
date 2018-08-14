package com.oromil.kotlinboilerplate.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//@Singleton
interface Api {

    companion object Creator{

        private val BASE_URL: String = ""

        fun create(): Api {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.nytimes.com/svc/")
                    .build()
            return retrofit.create(Api::class.java)
        }
    }
}