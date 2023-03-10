package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Crew(
    @SerializedName("crew")
    val crew: String,
    @SerializedName("role")
    val role: String
)