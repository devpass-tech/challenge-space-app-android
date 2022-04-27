package com.devpass.spaceapp.data.model.launch


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("large")
    val large: List<String>
)