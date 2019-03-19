package com.omni.usescases.database

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.omni.entities.Coordinates

class CoordinatesTypeConverter {

    @TypeConverter
    fun toJson(coordinates: Coordinates) = Gson().toJson(coordinates)

    @TypeConverter
    fun fromJson(string: String) = Gson().fromJson(string, Coordinates::class.java)
}
