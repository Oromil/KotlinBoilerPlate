package com.oromil.kotlinboilerplate.data.network

import com.oromil.kotlinboilerplate.data.network.entities.ResponseEntity
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface Api {

    @GET("topstories/v2/home.json?api_key=b1c97c7520db41d3b786c1c22e3d890e&")
    fun getNews(): Observable<ResponseEntity>

    companion object Creator{

        private const val BASE_URL: String = "https://api.nytimes.com/svc/"

        fun create(): Api {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(Api::class.java)
        }
    }
}