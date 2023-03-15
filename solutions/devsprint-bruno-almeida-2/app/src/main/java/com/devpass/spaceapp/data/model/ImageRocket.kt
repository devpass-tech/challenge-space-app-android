package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class ImageRocket(
    @SerializedName("original")
    val original: List<String>,
    @SerializedName("small")
    val small: List<Any>
) : java.io.Serializable