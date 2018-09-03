package com.oromil.kotlinboilerplate.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.oromil.kotlinboilerplate.data.local.dao.DataBaseDao
import com.oromil.kotlinboilerplate.data.entities.StoryEntity
import javax.inject.Singleton

@Singleton
@Database(entities = [StoryEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun mDao(): DataBaseDao
}