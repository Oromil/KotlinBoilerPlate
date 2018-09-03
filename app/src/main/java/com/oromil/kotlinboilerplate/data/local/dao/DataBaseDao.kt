package com.oromil.kotlinboilerplate.data.local.dao

import android.arch.persistence.room.*
import com.oromil.kotlinboilerplate.data.entities.StoryEntity
import io.reactivex.Flowable

@Dao
interface DataBaseDao {

    @Query("SELECT * FROM stories_table")
    fun getAllAsFlowable(): Flowable<List<StoryEntity>>

    @Query("SELECT * FROM stories_table")
    fun getAll(): List<StoryEntity>

    @Query("SELECT * FROM stories_table WHERE url = :url")
    fun getById(url:String): Flowable<StoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: StoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entities: List<StoryEntity>)

    @Update
    fun update(entity: StoryEntity)

    @Delete
    fun delete(entity: StoryEntity)
}