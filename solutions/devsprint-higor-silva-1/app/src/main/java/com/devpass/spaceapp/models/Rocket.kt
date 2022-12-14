package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Rocket(
    @SerializedName("rocket_name")
    val rocketName: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("flickr_images")
    val images: List<String> = emptyList()
): Serializable