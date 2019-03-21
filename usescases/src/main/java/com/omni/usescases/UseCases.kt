package com.omni.usescases

import android.arch.lifecycle.MutableLiveData
import com.omni.entities.City
import com.omni.usescases.repositories.CitiesRepository
import com.omni.usescases.repositories.cittiesRepository


fun numberIncrementer(liveData: MutableLiveData<Int>, incrementBy: Int = 1) {
    val oldValue = liveData.value ?: 0
    liveData.postValue(oldValue + incrementBy)

}


// useCase 1:search
// if is searching , then do not trigger action
// city name must not be null
// if all is ok , trigger search

fun retrieveCityByName(
    searchName: String?,
    retrieving: MutableLiveData<Boolean>,
    result: MutableLiveData<List<City>>,
    repository: CitiesRepository = cittiesRepository
) {
    searchName?.takeUnless { retrieving.value ?: false }
        ?.takeUnless { it.isBlank() }
        ?.also { retrieving.postValue(true) }
        ?.let { repository.searchCitiesByName(it) }      // scope functions also , let
        ?.also { result.postValue(it) }
        ?.also { retrieving.postValue(false) }
}

// usesCase 2: retrieve favorites cities ids (longs
// if is retrieving , then do not trigger action
// if favorites is empty , throw on exception
// if favorities is not empty  , convert them to ids(longs)


// usecase 3: retrieve  cities by Ids
// if is retrieving , then do not trigger action
// if all is ok , trigger action

fun retrieveCitiesByIds(
    ids: List<Long>, retrieving: MutableLiveData<Boolean>,
    result: MutableLiveData<List<City>>,
    repository: CitiesRepository = cittiesRepository
) {
    ids.takeUnless { retrieving.value ?: false }
        ?.also { retrieving.postValue(true) }
        ?.let { repository.retrieveCitiesByIds(it) }
        ?.also { result.postValue(it) }
        ?.also { retrieving.postValue(false) }


}


