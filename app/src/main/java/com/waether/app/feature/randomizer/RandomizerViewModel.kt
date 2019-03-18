package com.waether.app.feature.randomizer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.omni.usescases.Ticker


private const val DEFAULT_VALUE = 0
private const val INCREMENT_BY_VALUE = 0

class RandomizerViewModel : ViewModel() {

    val numberLiveData = MutableLiveData<Int>()
    private val ticker = initializeTicker()



    init {
        numberLiveData.value = DEFAULT_VALUE
    }

    private fun initializeTicker()=
         Ticker {
            val oldValue = numberLiveData.value ?: DEFAULT_VALUE
            numberLiveData.postValue(oldValue + INCREMENT_BY_VALUE)
        }

    override fun onCleared() {
        super.onCleared()
        ticker.cancel()
    }
}