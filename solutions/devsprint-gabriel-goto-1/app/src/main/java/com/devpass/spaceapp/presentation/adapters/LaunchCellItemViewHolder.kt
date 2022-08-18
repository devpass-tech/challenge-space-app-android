package com.devpass.spaceapp.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.LaunchesResponse
import com.devpass.spaceapp.databinding.ItemCellLaunchBinding

class LaunchCellItemViewHolder(
    private val itemBinding: ItemCellLaunchBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(response: LaunchesResponse) {
        with(itemBinding) {
            textviewName.text = response.nameRocket
            textviewDate.text = response.date
            textviewResult.setText(
                if (response.status) {
                    R.string.item_success
                } else {
                    R.string.item_fail
                }
            )
            textviewNumber.text =
                root.context.getString(R.string.item_flight_number, response.flightNumber)

            Glide
                .with(root.context)
                .load(response.links.patch.small)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(imageviewBadge)
        }
    }
}