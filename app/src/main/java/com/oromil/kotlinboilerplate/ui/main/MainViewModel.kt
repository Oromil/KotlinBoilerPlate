package com.oromil.kotlinboilerplate.ui.main

import android.arch.lifecycle.*
import com.oromil.kotlinboilerplate.data.DataManager
import com.oromil.kotlinboilerplate.data.entities.StoryEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mDataManager: DataManager)
    : ViewModel() {

    var update: MutableLiveData<Boolean> = MutableLiveData()

    var result: LiveData<List<StoryEntity>> = Transformations
            .switchMap(update) { loadNews() }

    private fun loadNews(): LiveData<List<StoryEntity>> {
        return LiveDataReactiveStreams.fromPublisher(mDataManager.getNews()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())!!)
    }

    fun update() {
        update.value = true
    }
}