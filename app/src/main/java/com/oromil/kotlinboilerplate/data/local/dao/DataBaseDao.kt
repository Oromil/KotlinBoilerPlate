package com.oromil.kotlinboilerplate.data.local.dao

import android.arch.persistence.room.*
import com.oromil.kotlinboilerplate.data.local.entities.DataBaseEntity
import io.reactivex.Flowable

@Dao
interface DataBaseDao {

    @Query("SELECT * FROM database_entity")
    fun getAll(): Flowable<List<DataBaseEntity>>

    @Query("SELECT * FROM database_entity WHERE id = :id")
    fun getById(id: Int): Flowable<DataBaseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: DataBaseEntity)

    @Update
    fun update(entity: DataBaseEntity)

    @Delete
    fun delete(entity: DataBaseEntity)
}