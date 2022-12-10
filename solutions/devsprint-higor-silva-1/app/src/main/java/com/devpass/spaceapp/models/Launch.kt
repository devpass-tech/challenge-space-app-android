package com.devpass.spaceapp.models

data class Launch(
    val flight_number: Int = 0,
    val mission_name: String = "",
    val date: String = "",
    val launch_success: Boolean? = false,
    val rocketRocketLaunch: RocketLaunch,
    val details: String? = "",
)

data class RocketLaunch(
    val rocket_id: String = ""
)