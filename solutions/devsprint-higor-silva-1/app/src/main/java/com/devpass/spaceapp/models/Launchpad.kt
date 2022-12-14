package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName

data class Launchpad(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("location")
    val location: Location,
    @SerializedName("attempted_launches")
    val attemptedLaunches: String = "",
    @SerializedName("successful_launches")
    val successfulLaunches: String = ""

)

data class Location(
    @SerializedName("name")
    val nameLocation: String = "",
    @SerializedName("region")
    val region: String = "",
    @SerializedName("latitude")
    val latitude: Double = 0.0,
    @SerializedName("longitude")
    val longitude: Double = 0.0
)