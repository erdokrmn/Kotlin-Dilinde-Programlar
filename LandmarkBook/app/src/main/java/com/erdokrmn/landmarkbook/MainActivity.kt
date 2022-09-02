package com.erdokrmn.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.erdokrmn.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var landmarkList:ArrayList<Landmark>
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        landmarkList= ArrayList<Landmark>()
        //Data
        val dolmabahce=Landmark("Dolmabahce","Beşiktaş",R.drawable.dolma)
        val ayasofia=Landmark("Ayasofia","Sultan Ahmet",R.drawable.ayasofia)
        val galata=Landmark("Galata","Taksim",R.drawable.galata)
        val yerebatan=Landmark("Yerebatan Sarnıcı","Fatih",R.drawable.yerebatan)

        landmarkList.add(dolmabahce)
        landmarkList.add(ayasofia)
        landmarkList.add(galata)
        landmarkList.add(yerebatan)

        binding.rv.layoutManager=LinearLayoutManager(this)
        val landmarkAdapter=LandmarkAdapter(landmarkList)
        binding.rv.adapter=landmarkAdapter
    }





}