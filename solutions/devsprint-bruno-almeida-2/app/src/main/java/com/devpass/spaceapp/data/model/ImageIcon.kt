package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class ImageIcon(
    @SerializedName("large")
    val large: String,
    @SerializedName("small")
    val small: String
) : java.io.Serializable