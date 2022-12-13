package com.devpass.spaceapp.presentation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ItemLaunchListBinding
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.formatDate
import com.devpass.spaceapp.models.getImgLink
import com.devpass.spaceapp.models.getStatus

class NextLaunchesAdapter(
    private val context: Context,
    private val launchList: List<Launch>,
    private val onClickListItem: (Launch) -> Unit
) :
    RecyclerView.Adapter<NextLaunchesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLaunchListBinding.bind(itemView)

        fun bind(selectedLaunch: Launch) {

            binding.ivLaunchList.load(selectedLaunch.getImgLink()) { size(250, 250) }
            binding.tvTitleLaunchList.text = selectedLaunch.title
            binding.tvSubtitleLaunchList.text = selectedLaunch.formatDate()
            binding.tvStatusLaunchList.text = selectedLaunch.getStatus(context)
            binding.tvPositionLaunchList.text = selectedLaunch.number.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_launch_list,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(launchList[position])
        holder.itemView.setOnClickListener {
            onClickListItem(launchList[position])
        }
    }

    override fun getItemCount(): Int = launchList.size
}
