package com.oromil.kotlinboilerplate.data

import com.oromil.kotlinboilerplate.data.local.AppDataBase
import com.oromil.kotlinboilerplate.data.local.dao.DataBaseDao
import com.oromil.kotlinboilerplate.data.network.Api
import com.oromil.kotlinboilerplate.data.network.entities.MultimediaEntity
import com.oromil.kotlinboilerplate.data.network.entities.StoryEntity
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val api: Api, private val mDataBase: AppDataBase) {

    private val mDbDao: DataBaseDao = mDataBase.mDao

    fun getNews(): Observable<List<StoryEntity>>? {
        return api.getNews().map { t ->
            t.results.forEach { storyEntity: StoryEntity ->
                if (storyEntity.multimedia.isEmpty())
                    storyEntity.multimedia.add(MultimediaEntity())
            }
            t.results
        }
    }
}