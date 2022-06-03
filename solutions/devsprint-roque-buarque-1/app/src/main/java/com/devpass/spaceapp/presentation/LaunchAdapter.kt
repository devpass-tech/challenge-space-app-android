package com.devpass.spaceapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.R

class LaunchAdapter: RecyclerView.Adapter<LaunchViewHolder>() {

    private var launchBadge = arrayOf(R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground, R.drawable.launch_badge)
    private var launchName = arrayOf("CRS-20", "Starlink 4-2", "FalconSat")
    private var launchDate = arrayOf("Jun 03, 2022", "Jun 03, 2022", "Jun 03, 2022")
    private var launchSuccess = arrayOf("Sucess", "Fail", "Sucess")
    private var launchNumber = arrayOf("#01","#02","#03")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_item, parent,false)
        return LaunchViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.itemBadgeLaunch.setImageResource(launchBadge[position])
        holder.itemNameLaunch.text = launchName[position]
        holder.itemDateLaunch.text = launchDate[position]
        holder.itemSuccessLaunch.text = launchSuccess[position]
        holder.itemNumberLaunch.text = launchNumber[position]
    }

    override fun getItemCount(): Int {
        return launchName.size
    }
}