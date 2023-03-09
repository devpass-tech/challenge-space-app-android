package com.devpass.spaceapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.ActivityLaunchCellItemBinding


interface NextLaunchesListener {
    fun onItemClick(position: Int, launch: NextLaunchesModel)
}

class NextLaunchesAdapter(
    private val items: List<NextLaunchesModel>,
    private var listener: NextLaunchesListener
) : RecyclerView.Adapter<LaunchCellItem>() {//ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchCellItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityLaunchCellItemBinding.inflate(layoutInflater, parent, false)
        return LaunchCellItem(binding)
    }

    override fun onBindViewHolder(holder: LaunchCellItem, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            listener.onItemClick(position, items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    fun setOnItemClickListener(listener: NextLaunchesListener) {
        this.listener = listener
    }

}

