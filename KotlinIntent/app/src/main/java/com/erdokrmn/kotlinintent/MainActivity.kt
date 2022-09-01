package com.erdokrmn.kotlinintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNext_Click(view: View)
    {
        val intent = Intent(applicationContext,NextActivity::class.java)
        intent.putExtra("KullanıcıAdı",ettKullaniciAdi.text.toString())
        intent.putExtra("GercekAd",ettGerçekAd.text.toString())
        startActivity(intent)
    }
}