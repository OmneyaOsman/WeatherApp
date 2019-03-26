package com.waether.app

import android.app.Application
import com.omni.usescases.Domain
import com.waether.app.core.activitiesLifecycleCallbacks

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(activitiesLifecycleCallbacks)
        Domain.integrateWith(this)
    }
}