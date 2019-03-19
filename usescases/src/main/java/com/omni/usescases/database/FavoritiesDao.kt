package com.omni.usescases.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface FavoritiesDao {

    @Query("select * from FavoriteCityId")
    fun queryAll():List<Long>
}