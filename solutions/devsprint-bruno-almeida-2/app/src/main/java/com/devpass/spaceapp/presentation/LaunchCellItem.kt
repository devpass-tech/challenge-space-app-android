package com.devpass.spaceapp.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.ActivityLaunchCellItemBinding

class LaunchCellItem(
    private val binding: ActivityLaunchCellItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : NextLaunchesModel) {
        with(binding) {
            numberRocket.text = item.number.toString()
            nameRocket.text = item.name
            dateLaunchRocket.text = item.date.toString()
            statusRocket.text = item.status.toString()
            Glide
                .with(root.context)
                .load(item.image)
                .circleCrop()
                .into(binding.imageRocket)
        }
    }
}