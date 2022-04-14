package com.devpass.spaceapp.launchCellView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ListItemBinding

class LaunchAdapter : ListAdapter<LaunchModel, LaunchAdapter.LaunchViewHolder>(LaunchAdapter) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private companion object : DiffUtil.ItemCallback<LaunchModel>() {

        override fun areItemsTheSame(oldItem: LaunchModel, newItem: LaunchModel): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: LaunchModel, newItem: LaunchModel): Boolean {
            return oldItem == newItem
        }
    }

    class LaunchViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageLaunch = itemView.findViewById<ImageView>(R.id.iv_logo)
        private val nameLaunch = itemView.findViewById<TextView>(R.id.tv_name)
        private val numberLaunch = itemView.findViewById<TextView>(R.id.tv_number)
        private val dateLaunch = itemView.findViewById<TextView>(R.id.tv_date)
        private val statusLaunch = itemView.findViewById<TextView>(R.id.tv_status)

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
}