package com.erdokrmn.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erdokrmn.landmarkbook.databinding.ActivityDetailsBinding

class ActivityDetails : AppCompatActivity() {
    private lateinit var binding :ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent=intent
        val selectedLandmark=intent.getSerializableExtra("landmark") as Landmark

        binding.tvLandmarkName.text=selectedLandmark.name
        binding.tvDistrict.text=selectedLandmark.district
        binding.imageView.setImageResource(selectedLandmark.image)
    }
}