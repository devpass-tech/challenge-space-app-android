package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("rocket_name")
    val name: String = "",
    @SerializedName("flickr_images")
    val images: List<String> = listOf()
)