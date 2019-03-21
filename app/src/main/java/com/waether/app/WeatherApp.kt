package com.waether.app

import android.app.Application
import com.omni.usescases.Domain

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Domain.integrateWith(this)
    }
}