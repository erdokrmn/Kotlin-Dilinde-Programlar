package com.erdokrmn.kotlindilindebasitkullanmlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //fonksiyonu çagırma ve işlem yaptırma
        fonksiyon2(15,20)

        // Simpson klasındaki tanımlamayı kullanıyorum
        val homer =Simpson(50,"Homer", "Nuclear")
        println(homer.age)

    }

    //fonksiyonda işlem yapma
    fun fonksiyon2(a:Int,b:Int)
    {
        textView6.text="sonuc ${a+b}"


    }
    // bu fonksiyon geriye INT tipinde döndürüyor
    fun fonksiyon3(a:Int,b:Int) : Int
    {
        return a*b

    }
    // Tasarım ekranındaki butonun fonksiyonu(Elle yazıyoruz otomatik gelmiyor)
    fun btnClick(view : View)
    {
        println("butona basınca yazılan")
        textView6.text="butona bastım çalıştı"
    }


}