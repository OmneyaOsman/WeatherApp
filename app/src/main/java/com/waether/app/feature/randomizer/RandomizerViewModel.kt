package com.waether.app.feature.randomizer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class RandomizerViewModel :ViewModel(){

    val numberLiveData= MutableLiveData<Int>()

    init {
        numberLiveData.value = 1
    }
    override fun onCleared() {
        super.onCleared()
    }
}