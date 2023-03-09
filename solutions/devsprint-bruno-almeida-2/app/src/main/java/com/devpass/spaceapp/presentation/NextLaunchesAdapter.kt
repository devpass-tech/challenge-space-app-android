package com.devpass.spaceapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.ActivityLaunchCellItemBinding


interface NextLaunchesListener {
    fun onItemSelected(position: Int)
}

class NextLaunchesAdapter(
    private val items: List<NextLaunchesModel>,
) : RecyclerView.Adapter<LaunchCellItem>() {

    private var listener: NextLaunchesListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchCellItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityLaunchCellItemBinding.inflate(layoutInflater, parent, false)
        return LaunchCellItem(binding)
    }

    override fun onBindViewHolder(holder: LaunchCellItem, position: Int) {
        val item = items[position]
        holder.bind(items[position])
        holder.view.setOnClickListener {
            listener?.onItemSelected(position)
        }
    }

    override fun getItemCount(): Int = items.size

    fun getItem(position: Int): NextLaunchesModel {
        return items[position]
    }

    fun setOnItemClickListener(listener: NextLaunchesListener) {
        this.listener = listener
    }

}
