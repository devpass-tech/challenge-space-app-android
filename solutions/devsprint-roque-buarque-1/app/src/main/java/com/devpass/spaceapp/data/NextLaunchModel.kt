package com.devpass.spaceapp.data

data class NextLaunchModel(
    val name: String,
    val date_utc: String,
    val flight_number: Int,
    val success: String,
    var links: Links
)

data class Links(
   val patch: Small
)

data class Small(
    val small: String
)