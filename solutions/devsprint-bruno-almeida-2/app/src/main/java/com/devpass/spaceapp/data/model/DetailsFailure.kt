package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class DetailsFailure(
    @SerializedName("altitude")
    val altitude: Int,
    @SerializedName("reason")
    val reason: String,
    @SerializedName("time")
    val time: Int
)