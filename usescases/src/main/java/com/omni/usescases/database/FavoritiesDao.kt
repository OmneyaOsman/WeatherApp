package com.omni.usescases.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.omni.entities.FavoriteCityId

@Dao
interface FavoritiesDao {

    @Query("select * from FavoriteCityId")
    fun queryAll():List<FavoriteCityId>

    @Insert
    fun  add(favoriteCityId:FavoriteCityId)

    @Delete
    fun  remove(favoriteCityId:FavoriteCityId)
}