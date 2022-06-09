package com.devpass.spaceapp.data.model

data class NextLaunchModel(
    val name: String,
    val date_utc: String,
    val flight_number: Int,
    val success: String,
    var links: Links
)

data class Links2(
   val patch: Small
)

data class Small(
    val small: String
)