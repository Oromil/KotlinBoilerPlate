package com.oromil.kotlinboilerplate.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.oromil.kotlinboilerplate.data.local.dao.DataBaseDao
import com.oromil.kotlinboilerplate.data.local.entities.DataBaseEntity

@Database(entities = [DataBaseEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract var mDao:DataBaseDao
}