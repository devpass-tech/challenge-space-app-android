package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NextLaunchesModel(
    @SerializedName("docs")
    val docs: List<NextLaunchModel>
) : Serializable

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
    val flightNumber: Int = 0,
    @SerializedName("details")
    val details: String = "",
    @SerializedName("rocket")
    val rocket: String = "",
    @SerializedName("launchpad")
    val launchPad: String = ""
) : Serializable

data class Links(
    @SerializedName("patch")
    val patch: Patch
) : Serializable

data class Patch(
    @SerializedName("small")
    val small: String
) : Serializable