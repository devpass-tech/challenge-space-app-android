package com.devpass.spaceapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ItemLaunchListBinding
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.formatDate
import java.text.SimpleDateFormat

class NextLaunchesAdapter(private val launchList: List<Launch>, private val onClickListItem: (Launch) -> Unit) :
    RecyclerView.Adapter<NextLaunchesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLaunchListBinding.bind(itemView)
        private val circleCropTransformation = CircleCropTransformation()

        fun bind(nextLaunchesModel: Launch) {
            val image = nextLaunchesModel.image.banner

            image?.let {
                binding.ivLaunchList.load(image) {
                    transformations(circleCropTransformation)
                    size(250, 250)
                }
            } ?: binding.ivLaunchList.load("https://dummyimage.com/400x400/000/fff") {
                size(
                    250,
                    250
                )
            }

            binding.tvTitleLaunchList.text = nextLaunchesModel.title
            binding.tvSubtitleLaunchList.text = nextLaunchesModel.formatDate()
            binding.tvStatusLaunchList.text =
                nextLaunchesModel.status?.let { if (it) "Success" else "Fail" } ?: "Inconclusive"
            binding.tvPositionLaunchList.text = nextLaunchesModel.number.toString()
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(launchList[position])

        holder.itemView.setOnClickListener {
            onClickListItem(launchList[position])
        }
    }


    override fun getItemCount(): Int = launchList.size
}
