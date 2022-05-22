package com.devpass.spaceapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.LaunchAdapterItemBinding

class LaunchAdapterItem(private val nextLaunches: List<NextLaunchesModel>) : RecyclerView.Adapter<LaunchAdapterItem.LauncherItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LauncherItemHolder {
        val itemBinding = LaunchAdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LauncherItemHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LauncherItemHolder, position: Int) {
        val nextLaunch: NextLaunchesModel = nextLaunches[position]
        holder.bind(nextLaunch)
    }

    override fun getItemCount(): Int = nextLaunches.size

    class LauncherItemHolder(private val itemBinding: LaunchAdapterItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(nextLaunch: NextLaunchesModel){
            itemBinding.launchName.text = nextLaunch.name
            //itemBinding.launchDate.text = //todo: check format to convert
            itemBinding.launchStatus.text = if (nextLaunch.status) "Success" else "Failure"
            itemBinding.launchNumber.text = "#${nextLaunch.flightNumber}"

            Glide
                .with(itemView)
                .load(nextLaunch.badge)
                .centerCrop()
                .into(itemBinding.launchBadge);
        }
    }
}