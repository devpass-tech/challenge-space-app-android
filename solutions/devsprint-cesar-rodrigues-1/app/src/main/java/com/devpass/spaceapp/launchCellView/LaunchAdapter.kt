package com.devpass.spaceapp.launchCellView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.R

class LaunchAdapter : RecyclerView.Adapter<LaunchViewHolder>() {

    private var listLaunch = listOf<LaunchModel>()

    fun updateList(contents: List<LaunchModel>) {
        listLaunch = contents
        notifyItemChanged(itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(listLaunch[position])
    }

    override fun getItemCount() = listLaunch.size
}

class LaunchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageLaunch = itemView.findViewById<ImageView>(R.id.iv_logo)
    private val nameLaunch = itemView.findViewById<TextView>(R.id.tv_name)
    private val dateLaunch = itemView.findViewById<TextView>(R.id.tv_date)
    private val statusLaunch = itemView.findViewById<TextView>(R.id.tv_status)

    fun bind(model: LaunchModel) {
        imageLaunch.setImageResource(model.image)
        nameLaunch.text = model.name
        dateLaunch.text = model.date
        statusLaunch.text = model.status
    }
}