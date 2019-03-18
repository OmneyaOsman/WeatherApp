package com.omni.usescases

import android.os.CountDownTimer

// Engine file handle common UI behavior functions


private const val FINISH_AFTER_MILLIS = 10*60000L
private const val INTERVAL_IN_MILLIS = 1000L

class Ticker(private val onTicking: (Long) -> Unit) :
    CountDownTimer(FINISH_AFTER_MILLIS, INTERVAL_IN_MILLIS) {


    override fun onTick(millisUntilFinish: Long) {
        onTicking(millisUntilFinish)
    }


    override fun onFinish() {
    }

}