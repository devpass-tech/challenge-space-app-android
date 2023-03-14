package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("flickr")
    val imageRocket: ImageRocket,
    @SerializedName("patch")
    val image: ImageIcon,
    @SerializedName("wikipedia")
    val wikipedia: String,
)