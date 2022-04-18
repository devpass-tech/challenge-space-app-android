package com.devpass.spaceapp.launchCellView

import androidx.recyclerview.widget.DiffUtil

data class LaunchModel(
    val image: Int,
    val number: String,
    val name: String,
    val date: String,
    val status: String
){
    companion object : DiffUtil.ItemCallback<LaunchModel>() {

        override fun areItemsTheSame(oldItem: LaunchModel, newItem: LaunchModel): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: LaunchModel, newItem: LaunchModel): Boolean {
            return oldItem == newItem
        }
    }
}