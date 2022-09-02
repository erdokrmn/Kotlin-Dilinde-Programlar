package com.erdokrmn.landmarkbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erdokrmn.landmarkbook.databinding.ActivityMainBinding
import com.erdokrmn.landmarkbook.databinding.RecyclerRowBinding


class LandmarkAdapter(val landmarkList:ArrayList<Landmark>) :RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>()
{
    class  LandmarkHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.rvViewTextView.text=landmarkList.get(position).name
    }

    override fun getItemCount(): Int {
        return landmarkList.size
    }
}