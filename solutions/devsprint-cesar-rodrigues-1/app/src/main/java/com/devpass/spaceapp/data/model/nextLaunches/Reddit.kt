package com.devpass.spaceapp.data.model.nextLaunches


import com.google.gson.annotations.SerializedName

data class Reddit(
    @SerializedName("campaign")
    val campaign: String,
    @SerializedName("launch")
    val launch: Any,
    @SerializedName("media")
    val media: Any,
    @SerializedName("recovery")
    val recovery: String
)