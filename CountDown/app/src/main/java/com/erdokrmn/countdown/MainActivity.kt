package com.erdokrmn.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Mili saniye ile çalıştığında 10 saniye istiyorsak 10k yazıyoruz
        object :CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {

                tv.text="Left : ${p0/1000}"
            }

            override fun onFinish() {
                tv.text="Left : 0"
            }

        }.start()
    }
}