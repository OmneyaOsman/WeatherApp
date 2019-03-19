package com.waether.app.feature.randomizer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.omni.usescases.numberIncrementer


 const val DEFAULT_VALUE = 0


class RandomizerViewModel : ViewModel() {




    val numberLiveData = MutableLiveData<Int>()

    init {
        numberLiveData.value = DEFAULT_VALUE
    }

    fun incrementNumber() {
        numberIncrementer(numberLiveData)
    }

}