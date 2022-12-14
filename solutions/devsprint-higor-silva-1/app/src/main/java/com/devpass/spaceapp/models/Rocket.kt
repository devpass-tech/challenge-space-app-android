package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("rocket_name")
    val rocketName: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("flickr_images")
    val images: List<String> = emptyList()
)