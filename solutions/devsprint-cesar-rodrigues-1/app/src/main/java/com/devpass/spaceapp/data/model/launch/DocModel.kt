package com.devpass.spaceapp.data.model.launch


import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class DocModel(
    @SerializedName("details")
    val details: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: Images,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("launch_attempts")
    val launchAttempts: Int,
    @SerializedName("launch_successes")
    val launchSuccesses: Int,
    @SerializedName("launches")
    val launches: List<String>,
    @SerializedName("locality")
    val locality: String,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("rockets")
    val rockets: List<String>,
    @SerializedName("status")
    val status: String,
    @SerializedName("timezone")
    val timezone: String
) {

    companion object : DiffUtil.ItemCallback<DocModel>() {
        override fun areItemsTheSame(oldItem: DocModel, newItem: DocModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DocModel, newItem: DocModel): Boolean {
            return oldItem == newItem
        }
    }
}