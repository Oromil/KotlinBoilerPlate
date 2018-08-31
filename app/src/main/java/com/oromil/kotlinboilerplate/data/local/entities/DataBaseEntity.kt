package com.oromil.kotlinboilerplate.data.local.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "database_entity")
data class DataBaseEntity(
        @PrimaryKey
        var id: Long,
        var value: String
)
