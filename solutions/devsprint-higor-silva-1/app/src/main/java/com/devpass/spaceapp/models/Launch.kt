package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName

data class Launch(
    @SerializedName("links")
    var folder: Links,
    @SerializedName("flight_number")
    val number: Int = 0,
    @SerializedName("mission_name")
    val mission_name: String = "",
    @SerializedName("launch_date_utc")
    val date: String = "",
    @SerializedName("launch_success")
    val status: Boolean? = false,
    @SerializedName("rocket")
    val rocketLaunch: RocketLaunch,
    @SerializedName("details")
    val details: String? = "",
)

data class RocketLaunch(
    @SerializedName("rocket_id")
    val rocket_id: String = ""
)

data class Links(
    @SerializedName("mission_patch_small")
    val banner: String? = ""
)