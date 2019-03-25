package com.omni.usescases.repositories

import com.omni.entities.City
import com.omni.entities.FavoriteCityId

open class CitiesRepositoryMock : CitiesRepository {

    override fun searchCitiesByName(name: String): List<City> {
        return listOf()
    }

    override fun retrieveFavoriteCitiesIds(): List<FavoriteCityId> {
        return listOf()
    }

    override fun retrieveCitiesByIds(citiesIds: List<Long>): List<City> {
        return listOf()
    }

    override fun addFavoriteCityId(favoriteCityId: FavoriteCityId) {
    }

    override fun removeFavoriteCityId(favoriteCityId: FavoriteCityId) {
    }
}