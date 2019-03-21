package com.waether.app.feature.randomizer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


private const val DEFAULT_VALUE = 0
private const val INCREMENT_BY_VALUE = 0

class RandomizerViewModel : ViewModel() {

    val numberLiveData = MutableLiveData<Int>()



    init {
        numberLiveData.value = DEFAULT_VALUE
    }



    override fun onCleared() {
        super.onCleared()
    }
}