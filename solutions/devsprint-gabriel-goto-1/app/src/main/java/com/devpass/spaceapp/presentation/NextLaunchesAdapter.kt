package com.devpass.spaceapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.data.model.LaunchesResponse
import com.devpass.spaceapp.databinding.ItemCellLaunchBinding

class NextLaunchesAdapter(
    private val launches: List<LaunchesResponse>
) : RecyclerView.Adapter<LaunchCellItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchCellItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCellLaunchBinding.inflate(inflater)
        return LaunchCellItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaunchCellItemViewHolder, position: Int) {
       val item = launches[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = launches.size
}