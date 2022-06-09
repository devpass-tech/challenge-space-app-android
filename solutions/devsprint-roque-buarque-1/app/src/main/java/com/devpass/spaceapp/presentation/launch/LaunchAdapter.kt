package com.devpass.spaceapp.presentation.launch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.NextLaunchesItem

class LaunchAdapter(private val launchList: List<NextLaunchesItem>): RecyclerView.Adapter<LaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_item, parent,false)
        return LaunchViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val itemLaunch = launchList[position]
        holder.bind(itemLaunch)
    }

    override fun getItemCount(): Int {
        return launchList.size
    }
}