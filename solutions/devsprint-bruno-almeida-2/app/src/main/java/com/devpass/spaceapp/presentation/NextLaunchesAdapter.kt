package com.devpass.spaceapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.ActivityLaunchCellItemBinding

class NextLaunchesAdapter(
    private val items: List<NextLaunchesModel>,
    private val listener: (launch: NextLaunchesModel) -> Unit,
) : RecyclerView.Adapter<LaunchCellItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchCellItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityLaunchCellItemBinding.inflate(layoutInflater, parent, false)
        return LaunchCellItem(binding)
    }

    override fun onBindViewHolder(holder: LaunchCellItem, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener(item)
        }
    }

    override fun getItemCount(): Int = items.size

}

