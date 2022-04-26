package com.devpass.spaceapp.data.model


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("large")
    val large: List<String>
)