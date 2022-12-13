package com.devpass.spaceapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ItemLaunchListBinding
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.formatDate

class NextLaunchesAdapter(
    private val context: Context,
    private val launchList: List<Launch>,
    private val onClickListItem: (Launch) -> Unit
) :
    RecyclerView.Adapter<NextLaunchesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLaunchListBinding.bind(itemView)

        fun bind(selectedLaunch: Launch) {
            val image = selectedLaunch.image.banner

            image?.let {
                binding.ivLaunchList.load(image) { size(250, 250) }
            } ?: binding.ivLaunchList.load("https://dummyimage.com/400x400/000/fff") {
                size(
                    250,
                    250
                )
            }

            binding.tvTitleLaunchList.text = selectedLaunch.title
            binding.tvSubtitleLaunchList.text = selectedLaunch.formatDate()
            binding.tvStatusLaunchList.text =
                selectedLaunch.status?.let {
                    if (it) context.getString(R.string.success) else context.getString(
                        R.string.fail
                    )
                } ?: context.getString(R.string.uknown)
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
