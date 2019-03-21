package com.omni.usescases.repositories

import com.omni.entities.City
import com.omni.entities.FavoriteCityId
import com.omni.usescases.database.WeatherDatabase
import com.omni.usescases.database.weatherDatabase

val cittiesRepository by lazy {
    CitiesRepository()
}

class CitiesRepository(private val database: WeatherDatabase = weatherDatabase) {
    fun searchCitiesByName(name: String): List<City> = database.citiesDao.queryCitiesByName(name)

    fun retrieveFavoritieCitiesIds(): List<FavoriteCityId> = database.favoritiesDao.queryAll()
    fun retrieveCitiesByIds(citiesIds: List<Long>): List<City> = database.citiesDao.queryCitiesById(citiesIds)

    fun addFavoriteCityId(favoriteCityId: FavoriteCityId) = database.favoritiesDao.insert(favoriteCityId)

    fun removeFavoriteCityId(favoriteCityId: FavoriteCityId) = database.favoritiesDao.delete(favoriteCityId)
}