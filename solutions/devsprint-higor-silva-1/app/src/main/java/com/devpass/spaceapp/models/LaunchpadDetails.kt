package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LaunchpadDetails(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("location")
    val location: Location,
    @SerializedName("attempted_launches")
    val attemptedLaunches: String = "",
    @SerializedName("successful_launches")
    val successfulLaunches: String = "",
    @SerializedName("site_name_long")
    val siteName: String = ""
) : Serializable