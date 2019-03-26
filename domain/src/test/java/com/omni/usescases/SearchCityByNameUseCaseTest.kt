package com.omni.usescases

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.omni.entities.City
import com.omni.usescases.engine.toMutableLiveData
import com.omni.usescases.repositories.CitiesRepositoryMock
import com.omni.usescases.usecases.SearchCityByNameUseCase
import com.omni.usescases.usecases.fakeResultIdsList
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class SearchCityByNameUseCaseTest{
    @JvmField
    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()

// usecase 1 : search city by name
// if is searching, then do not trigger action
// city name must not be null
// city name must not be blank
// if all is OK, trigger search

    // if all is OK, trigger search
    @Test
    fun `invoke with successful response then update result`() {

        // Arrange
        val searching = MutableLiveData<Boolean>()
        val cityName = "any name"
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val searchCityByNameUseCase =
            SearchCityByNameUseCase(searching, result, repository)

        // Act
        searchCityByNameUseCase.invoke(cityName)

        // Assert
        Assert.assertTrue(result.value!!.isNotEmpty())

    }

    // city name must not be null
    @Test
    fun `invoke with null cityName then do not update result`() {

        // Arrange
        val searching = MutableLiveData<Boolean>()
        val cityName: String? = null
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val searchCityByNameUseCase =
            SearchCityByNameUseCase(searching, result, repository)

        // Act
        searchCityByNameUseCase.invoke(cityName)


        // Assert
        Assert.assertTrue(result.value == null)

    }


    // if is searching, then do not trigger action
    @Test
    fun `invoke with searching as true then do not update result`() {

        // Arrange
        val searching = true.toMutableLiveData()
        val cityName: String = "any name"
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val searchCityByNameUseCase =
            SearchCityByNameUseCase(searching, result, repository)

        // Act
        searchCityByNameUseCase.invoke(cityName)


        // Assert
        Assert.assertTrue(result.value == null)

    }

    @Test
    fun `invoke with blank city name then do not update result`() {

        // Arrange
        val searching = false.toMutableLiveData()
        val cityName: String = ""
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val searchCityByNameUseCase = SearchCityByNameUseCase(searching, result, repository)

        // Act
        searchCityByNameUseCase.invoke(cityName)


        // Assert
        Assert.assertTrue(result.value == null)

    }

}

class CitiesRepositoryForSearchCityByName : CitiesRepositoryMock() {


    override fun searchCitiesByName(name: String): List<City> {
        return fakeResultIdsList
    }
}