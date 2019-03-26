package com.waether.app.core

import android.app.Activity
import android.app.Application
import android.os.Bundle

val activitiesLifecycleCallbacks by lazy { ActivitiesLifecycleCallbacks() }

class ActivitiesLifecycleCallbacks : Application.ActivityLifecycleCallbacks {

    override fun onActivityPaused(activity: Activity?) {

    }

    override fun onActivityResumed(activity: Activity?) {

    }

    override fun onActivityStarted(activity: Activity?) {

    }

    override fun onActivityDestroyed(activity: Activity?) {

    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

    }

    override fun onActivityStopped(activity: Activity?) {

    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        activity.javaClass
            .getAnnotation(ContentViewId::class.java)
            ?.layoutId
            ?.also { activity.setContentView(it) }
    }

}
