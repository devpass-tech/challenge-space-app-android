package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class NextLaunchesModel(
    @SerializedName("date_utc")
    val date_utc: String,
    @SerializedName("details")
    val details: String,
    @SerializedName("failures")
    val detailsFailures: List<DetailsFailure>,
    @SerializedName("flight_number")
    val flight_number: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("launchpad")
    val launchpad: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("name")
    val name: String,
    @SerializedName("rocket")
    val rocket: String,
    @SerializedName("success")
    val status: Boolean,
)