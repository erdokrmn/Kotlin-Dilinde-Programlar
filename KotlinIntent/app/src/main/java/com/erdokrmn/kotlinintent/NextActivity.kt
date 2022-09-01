package com.erdokrmn.kotlinintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_next2.*

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next2)

        val intent =intent
        val kullaniciadi=intent.getStringExtra("KullanıcıAdı")
        val gercekad=intent.getStringExtra("GercekAd")
        tvKullaniciAdi.text="Kullanıcı Adı :"+kullaniciadi
        tvGerçekAd.text="Gercek Ad :"+gercekad
    }
}