package com.omni.usescases.usecases

import android.arch.lifecycle.MutableLiveData
import com.omni.usescases.repositories.CitiesRepository
import com.omni.usescases.repositories.citiesRepository

//target method+
// usecase 3 : retrieve cities by Ids
// if is retrieving, then do not trigger action
// if all is Ok, trigger action
class SearchCitiesByIds(
    private val result: CitiesResult,
    private val searching: MutableLiveData<Boolean>,
    private val repository: CitiesRepository = citiesRepository
) {
    operator fun invoke(citiesIds: List<Long>) {
        citiesIds.takeUnless { searching.value ?: false }
            ?.also { searching.postValue(true) }
            ?.let { repository.retrieveCitiesByIds(it) }
            ?.also { result.postValue(it) }
            ?.also { searching.postValue(false) }

    }

}