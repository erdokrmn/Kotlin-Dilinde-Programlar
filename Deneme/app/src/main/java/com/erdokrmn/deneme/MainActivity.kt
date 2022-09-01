package com.erdokrmn.deneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun deneme(view: View){
        println("deneme123")
        println("Ahmet mehmet")
        println("Fatih")

    }
}