package com.erdokrmn.basitverikayt

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences :Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //SharedPrefences Initialize
        sharedPreferences=this.getSharedPreferences("com.erdokrmn.basitverikayt",Context.MODE_PRIVATE)
        ageFromPreferences=sharedPreferences.getInt("Yaş",-1)
        if(ageFromPreferences==-1){
            tvYas.text="Yaşınız :"
        }else{
            tvYas.text="Yaşınız : $ageFromPreferences"
        }
    }


   fun btnKayıt_Click(view: View)
   {


       var yas = ettYas.text.toString().toIntOrNull()
       if (yas!=null){
           tvYas.text="Yaşınız :" + yas
           sharedPreferences.edit().putInt("Yaş",yas).apply()
       }
       else{
           ettYas.hint="Lütfen Yaşınızı giriniz."
       }
   }
    fun btnSil_Click(view: View)
    {
        ageFromPreferences=sharedPreferences.getInt("Yaş",-1)
        if (ageFromPreferences!=-1){
            sharedPreferences.edit().remove("Yaş").apply()
            tvYas.text="Yaşınız :"
        }
    }
}