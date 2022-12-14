package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Launch(
    @SerializedName("links")
    var image: Links,
    @SerializedName("flight_number")
    val number: Int = 0,
    @SerializedName("mission_name")
    val title: String = "",
    @SerializedName("launch_date_utc")
    val date: String = "",
    @SerializedName("launch_success")
    val status: Boolean? = false,
    @SerializedName("rocket")
    val rocketLaunch: RocketLaunch,
    @SerializedName("details")
    val details: String? = "",
    @SerializedName("launch_site")
    val launchpadId: LaunchpadId,
    val rocketDetails: RocketDetails? = null,
    val launchpadDetails: LaunchpadDetails? = null
) : Serializable




