package com.devpass.spaceapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.spaceapp.data.model.NextLaunchModel
import com.devpass.spaceapp.databinding.LaunchAdapterItemBinding

private const val SUCCESS_LAUNCH = "Success"
private const val FAILURE_LAUNCH = "Failure"

class LaunchAdapterItem(
    private val nextLaunch: List<NextLaunchModel>,
    private val onItemClicked: (nextLaunch: NextLaunchModel) -> Unit
) :
    RecyclerView.Adapter<LaunchAdapterItem.LauncherItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LauncherItemHolder {
        val itemBinding =
            LaunchAdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LauncherItemHolder(itemBinding, onItemClicked)
    }

    override fun onBindViewHolder(holder: LauncherItemHolder, position: Int) {
        val nextLaunch: NextLaunchModel = nextLaunch[position]
        holder.bind(nextLaunch, onItemClicked)
    }

    override fun getItemCount(): Int = nextLaunch.size

    class LauncherItemHolder(private val itemBinding: LaunchAdapterItemBinding,
                             private val onItemClicked: (nextLaunch: NextLaunchModel) -> Unit) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(nextLaunch: NextLaunchModel, onItemClicked: (NextLaunchModel) -> Unit) {
            itemBinding.launchName.text = nextLaunch.nameRocket
            itemBinding.launchDate.text = nextLaunch.date
            itemBinding.launchStatus.text =
                if (nextLaunch.status) SUCCESS_LAUNCH else FAILURE_LAUNCH
            itemBinding.launchNumber.text = "#${nextLaunch.flightNumber}"

            Glide
                .with(itemView)
                .load(nextLaunch.links.patch.small)
                .centerCrop()
                .into(itemBinding.launchBadge)

            itemBinding.launchContent.setOnClickListener {
                this.onItemClicked(nextLaunch)
            }
        }
    }
}