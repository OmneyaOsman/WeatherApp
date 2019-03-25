package com.omni.usescases

import android.app.Application
import android.arch.lifecycle.MutableLiveData


// liveData here as channel to access application
// internal for module
internal val applicationLiveData = MutableLiveData<Application>()
// to return value of any MutableLiveData
internal fun <T>MutableLiveData<T>.getNonNull():T =value!!

//class InvokableLiveData<T> :MutableLiveData<T>(){
//    operator fun  invoke ()= value!!
//}
internal fun MutableLiveData<Application>.getApplication():Application =value!!

object Domain {

    fun integrateWith(application: Application) {

        applicationLiveData.value = application
    }

}