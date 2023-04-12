package com.nabil.banglaclock

interface OnTimeChangeListener {
    fun onTimeChanged(time : String)
    fun onStartOrStop(isActive : Boolean)
}