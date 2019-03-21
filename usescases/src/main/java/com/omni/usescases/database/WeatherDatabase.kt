package com.omni.usescases.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.omni.entities.City
import com.omni.entities.FavoriteCityId
import com.omni.usescases.applicationLiveData
import com.omni.usescases.getApplication


val weatherDatabase by lazy{
    initializeDatabase(applicationLiveData.getApplication())
}
@Database( entities = [City::class , FavoriteCityId::class] , version = 1 , exportSchema = false )
@TypeConverters(CoordinatesTypeConverter::class)
abstract class WeatherDatabase :RoomDatabase(){
    abstract val citiesDao:CitiesDao
    abstract val favoritiesDao :FavoritiesDao
}