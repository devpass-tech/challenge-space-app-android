package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class NextLaunchesModel(
    @SerializedName("docs")
    val docs: List<NextLaunchModel>
)

data class NextLaunchModel(
    @SerializedName("links")
    val links: Links,
    @SerializedName("name")
    val nameRocket: String = "",
    @SerializedName("date_utc")
    val date: String = "",
    @SerializedName("success")
    val status: Boolean = false,
    @SerializedName("flight_number")
    val flightNumber: Int = 0
)

data class Links(
    @SerializedName("patch")
    val patch: Patch
)

data class Patch(
    @SerializedName("small")
    val small: String
)