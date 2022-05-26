package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class RocketModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("flickr_images")
    val image: List<String>
)