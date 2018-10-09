package com.oromil.kotlinboilerplate.data

import com.oromil.kotlinboilerplate.data.local.dao.DataBaseDao
import com.oromil.kotlinboilerplate.data.network.Api
import com.oromil.kotlinboilerplate.data.entities.MultimediaEntity
import com.oromil.kotlinboilerplate.data.entities.StoryEntity
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val api: Api, private val dataBaseDao: DataBaseDao) {

    fun getNews(): Flowable<List<StoryEntity>>? {
        return api.getNews().map { response ->
            response.results.forEach { storyEntity: StoryEntity ->
                if (storyEntity.multimedia.isEmpty())
                    storyEntity.multimedia.add(MultimediaEntity())
            }
            response.results
        }.map { t: List<StoryEntity> ->
            dataBaseDao.insert(t)
            t
        }.onErrorReturn { dataBaseDao.getAll() }
                .toFlowable(BackpressureStrategy.BUFFER)
    }
}