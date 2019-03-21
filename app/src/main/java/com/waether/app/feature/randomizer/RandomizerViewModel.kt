package com.waether.app.feature.randomizer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.omni.usescases.Ticker
import com.omni.usescases.randomNumberGenerator


private const val DEFAULT_VALUE = 0
private const val INCREMENT_BY_VALUE = 0

class RandomizerViewModel : ViewModel() {

    private val ticker = initializeTicker()
    val numberLiveData = MutableLiveData<Int>()



    init {
        numberLiveData.value = DEFAULT_VALUE
        ticker.start()
    }

    private fun initializeTicker()=
         Ticker {
            numberLiveData.postValue(randomNumberGenerator().toInt())
        }

    override fun onCleared() {
        super.onCleared()
        ticker.cancel()
    }
}