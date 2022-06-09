package com.devpass.spaceapp.presentation.launch

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.NextLauchesItem
import com.devpass.spaceapp.data.model.NextLaunchModel

class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val itemBadgeLaunch:ImageView = itemView.findViewById(R.id.imageViewBadge)
    private val itemNameLaunch:TextView = itemView.findViewById(R.id.textViewName)
    private val itemDateLaunch:TextView = itemView.findViewById(R.id.textViewDate)
    private val itemSuccessLaunch:TextView = itemView.findViewById(R.id.textViewSuccess)
    private val itemNumberLaunch:TextView = itemView.findViewById(R.id.textViewNumber)

    fun bind(item: NextLauchesItem){
        Glide
            .with(itemView)
            .load(item.links.patch.small)
            .centerCrop()
            .into(itemBadgeLaunch)

        itemNameLaunch.text = item.name
        itemDateLaunch.text = item.dateLocal
        itemSuccessLaunch.text = item.success.toString()
        itemNumberLaunch.text = item.flightNumber.toString()
    }
}