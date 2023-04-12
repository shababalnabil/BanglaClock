package com.nabil.bengaliclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.nabil.banglaclock.BanglaClock
import com.nabil.banglaclock.OnTimeChangeListener
import java.util.*

class MainActivity : AppCompatActivity() {
    val banglaClock = BanglaClock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textview)


        banglaClock.onTimeChangeListener = object : OnTimeChangeListener {
            override fun onStartOrStop(isActive: Boolean) {

            }
            override fun onTimeChanged(time: String) {
                textView.text = time
            }
        }


    }

    override fun onStart() {
        super.onStart()
        banglaClock.startClock()
    }

    override fun onStop() {
        super.onStop()
        banglaClock.stopClock()
    }

}