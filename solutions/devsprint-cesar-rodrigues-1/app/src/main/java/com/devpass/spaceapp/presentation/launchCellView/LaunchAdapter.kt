package com.devpass.spaceapp.presentation.launchCellView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.spaceapp.data.model.launch.DocModel
import com.devpass.spaceapp.databinding.ListItemBinding

class LaunchAdapter : ListAdapter<DocModel, LaunchViewHolder>(DocModel) {

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
    private val statusLaunch = binding.tvStatus

    fun bind(model: DocModel) {
        Glide.with(itemView).load(model.images.large[0]).into(imageLaunch)
        nameLaunch.text = model.name
        statusLaunch.text = model.status
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