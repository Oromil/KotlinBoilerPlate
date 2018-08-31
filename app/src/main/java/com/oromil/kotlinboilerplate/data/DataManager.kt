package com.oromil.kotlinboilerplate.data

import com.oromil.kotlinboilerplate.data.network.Api
import com.oromil.kotlinboilerplate.data.network.entities.MultimediaEntity
import com.oromil.kotlinboilerplate.data.network.entities.StoryEntity
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val api: Api) {

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