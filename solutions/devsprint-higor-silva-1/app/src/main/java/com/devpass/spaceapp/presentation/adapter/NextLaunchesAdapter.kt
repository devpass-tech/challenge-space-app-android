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
import com.devpass.spaceapp.formatDate
import com.devpass.spaceapp.getImgLink
import com.devpass.spaceapp.getStatus

class NextLaunchesAdapter(
    private val context: Context,
    private val launchList: List<Launch>,
    private val onClickListItem: (Launch) -> Unit
) :
    RecyclerView.Adapter<NextLaunchesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLaunchListBinding.bind(itemView)

        fun bind(selectedLaunch: Launch) {

            binding.apply {
                ivLaunchList.load(selectedLaunch.getImgLink()) { size(250, 250) }
                tvTitleLaunchList.text = selectedLaunch.title
                tvSubtitleLaunchList.text = selectedLaunch.formatDate()
                tvStatusLaunchList.text = selectedLaunch.getStatus(context)
                tvPositionLaunchList.text = context.resources.getString(R.string.txt_number_launch).format(selectedLaunch.number)
            }
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
