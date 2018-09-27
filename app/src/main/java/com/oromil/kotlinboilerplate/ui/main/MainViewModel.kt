package com.oromil.kotlinboilerplate.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.oromil.kotlinboilerplate.data.DataManager
import com.oromil.kotlinboilerplate.data.entities.StoryEntity
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mDataManager: DataManager)
    : ViewModel() {

    private val liveData: MutableLiveData<List<StoryEntity>> = MutableLiveData()

    fun setContent(data: List<StoryEntity>) {
        liveData.value = data
    }

//    fun getLiveData():LiveData<List<StoryEntity>>{
//        return liveData
//    }

    fun subscribeOnNewsUpdates():LiveData<List<StoryEntity>> {
//        mDataManager.getNews()
//                ?.subscribeOn(Schedulers.io())
//                ?.observeOn(AndroidSchedulers.mainThread())
//                ?.subscribe({ dataList -> setContent(dataList) },
//                        { throwable -> throwable.printStackTrace() })
        return LiveDataReactiveStreams.fromPublisher(mDataManager.getNews()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())!!)
    }
}