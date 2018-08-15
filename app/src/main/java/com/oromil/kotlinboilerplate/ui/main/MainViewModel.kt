package com.oromil.kotlinboilerplate.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.oromil.kotlinboilerplate.data.network.entities.StorieEntity

class MainViewModel : ViewModel() {

    private val liveData: MutableLiveData<List<StorieEntity>> = MutableLiveData()

    fun setContent(data: List<StorieEntity>) {
        liveData.value = data
    }

    fun getLiveData():LiveData<List<StorieEntity>>{
        return liveData
    }
}