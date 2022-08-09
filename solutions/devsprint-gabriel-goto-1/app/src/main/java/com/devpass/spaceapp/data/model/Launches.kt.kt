package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Launches(
    @SerializedName("links")
    val links: Links,
    @SerializedName("name")
    val nameRocket: String,
    @SerializedName("date_utc")
    val date: String,
    @SerializedName("success")
    val status: Boolean,
    @SerializedName("flight_number")
    val flightNumber: Int
)
