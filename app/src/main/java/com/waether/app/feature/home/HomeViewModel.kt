package com.waether.app.feature.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.omni.entities.City
import com.omni.usescases.CitiesResult
import com.omni.usescases.SearchCityByNameUseCase
import com.omni.usescases.engine.toMutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    val searchProgress: MutableLiveData<Boolean> = false.toMutableLiveData(),
    val citiesResult: CitiesResult = ArrayList<City>().toMutableLiveData(),
    private val searchCityByName: SearchCityByNameUseCase = SearchCityByNameUseCase(
        searchProgress,
        citiesResult
    )
) : ViewModel() {
    fun onSearchButtonClicked(cityName: String?) {
        Observable.fromCallable { searchCityByName(cityName) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}