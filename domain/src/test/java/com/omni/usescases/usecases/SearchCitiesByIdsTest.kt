package com.omni.usescases.usecases

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.omni.entities.City
import com.omni.usescases.repositories.CitiesRepositoryMock
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class SearchCitiesByIdsTest {

    @JvmField
    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `invoke with successfully response then update resultLiveData value`() {

        //Arrange
        val searching = MutableLiveData<Boolean>()
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositorySuccessfulSearchCitiesByIds()
        val citiesIds = listOf(1L, 2L, 3L)
        val searchCitiesByIds = SearchCitiesByIds(result, searching, repository)

        //Act
        searchCitiesByIds(citiesIds)

        //Assert
        Assert.assertTrue(result.value!!.isNotEmpty())
    }


    @Test
    fun `invoke while searching then do not update result`() {
        //Arrange
        val result = MutableLiveData<List<City>>()
        val searching = MutableLiveData<Boolean>()
        val repository = CitiesRepositorySuccessfulSearchCitiesByIds()
        val citiesIds = listOf(1L, 2L, 3L)
        val searchCitiesByIds = SearchCitiesByIds(result, searching, repository)

        //Act
        searching.value = true
        searchCitiesByIds(citiesIds)

        //Assert
        Assert.assertTrue(result.value === null)

    }


}

val fakeResultIdsList = listOf(City(0L, "", "", null), City(0L, "", "", null))

class CitiesRepositorySuccessfulSearchCitiesByIds : CitiesRepositoryMock() {


    override fun retrieveCitiesByIds(citiesIds: List<Long>): List<City> {
        return fakeResultIdsList
    }
}