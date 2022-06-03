package com.devpass.spaceapp.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.R

class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var itemBadgeLaunch:ImageView = itemView.findViewById(R.id.imageViewBadge)
    var itemNameLaunch:TextView = itemView.findViewById(R.id.textViewName)
    var itemDateLaunch:TextView = itemView.findViewById(R.id.textViewDate)
    var itemSuccessLaunch:TextView = itemView.findViewById(R.id.textViewSuccess)
    var itemNumberLaunch:TextView = itemView.findViewById(R.id.textViewNumber)
}