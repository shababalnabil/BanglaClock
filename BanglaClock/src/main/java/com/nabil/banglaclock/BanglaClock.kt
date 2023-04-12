package com.nabil.banglaclock

import android.os.Handler
import android.os.Looper
import java.text.SimpleDateFormat
import java.util.*

class BanglaClock {
    var onTimeChangeListener : OnTimeChangeListener? = null
    var format = "hh:mm:ss a"

    private val clockHandler = Handler(Looper.getMainLooper())
    private val clockRunnable = object : Runnable {
        override fun run() {
            val timeFormat = SimpleDateFormat(format, Locale.getDefault())
            val date = Date()
            val timeString = timeFormat.format(date)
            onTimeChangeListener?.onTimeChanged(TimeTranslator.translate(timeString))
            clockHandler.postDelayed(this, 1000)
        }
    }

    fun startClock(){
        clockHandler.post(clockRunnable)
        onTimeChangeListener?.onStartOrStop(true)
    }

    fun stopClock(){
        clockHandler.removeCallbacks(clockRunnable)
        onTimeChangeListener?.onStartOrStop(false)
    }

}