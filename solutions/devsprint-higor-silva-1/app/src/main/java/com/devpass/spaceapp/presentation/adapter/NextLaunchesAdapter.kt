package com.devpass.spaceapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ItemLaunchListBinding
import com.devpass.spaceapp.models.NextLaunchesModel

class NextLaunchesAdapter(private val list: List<NextLaunchesModel>) :
    RecyclerView.Adapter<NextLaunchesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLaunchListBinding.bind(itemView)

        fun bind(nextLaunchesModel: NextLaunchesModel) {
            binding.ivLaunchList.setImageResource(nextLaunchesModel.image)
            binding.tvTitleLaunchList.text = nextLaunchesModel.title
            binding.tvSubtitleLaunchList.text = nextLaunchesModel.subtitle
            binding.tvStatusLaunchList.text = nextLaunchesModel.status
            binding.tvPositionLaunchList.text = nextLaunchesModel.position
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size
}