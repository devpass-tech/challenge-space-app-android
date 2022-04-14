package com.devpass.spaceapp.launchCellView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.databinding.ListItemBinding

class LaunchAdapter : ListAdapter<LaunchModel, LaunchViewHolder>(LaunchModel) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class LaunchViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val imageLaunch = binding.ivLogo
    private val nameLaunch = binding.tvName
    private val numberLaunch = binding.tvNumber
    private val dateLaunch = binding.tvDate
    private val statusLaunch = binding.tvStatus

    fun bind(model: LaunchModel) {
        with(itemView) {
            imageLaunch.setImageResource(model.image)
            nameLaunch.text = model.name
            numberLaunch.text = model.number
            dateLaunch.text = model.date
            statusLaunch.text = model.status
        }
    }

    companion object {
        fun from(parent: ViewGroup): LaunchViewHolder {
            return LaunchViewHolder(
                ListItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }
}