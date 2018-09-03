package com.oromil.kotlinboilerplate.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.oromil.kotlinboilerplate.data.entities.StoryEntity

class MainViewModel : ViewModel() {

    private val liveData: MutableLiveData<List<StoryEntity>> = MutableLiveData()

    fun setContent(data: List<StoryEntity>) {
        liveData.value = data
    }

    fun getLiveData():LiveData<List<StoryEntity>>{
        return liveData
    }
}