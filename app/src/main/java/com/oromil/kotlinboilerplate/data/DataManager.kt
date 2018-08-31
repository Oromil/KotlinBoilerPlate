package com.oromil.kotlinboilerplate.data

import com.oromil.kotlinboilerplate.data.local.AppDataBase
import com.oromil.kotlinboilerplate.data.local.dao.DataBaseDao
import com.oromil.kotlinboilerplate.data.network.Api
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val api: Api, private val mDataBase: AppDataBase) {

    private val mDbDao: DataBaseDao = mDataBase.mDao

}