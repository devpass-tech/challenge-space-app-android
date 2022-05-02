package com.devpass.spaceapp.data.model.nextLaunches


import com.google.gson.annotations.SerializedName

data class Core(
    @SerializedName("core")
    val core: String,
    @SerializedName("flight")
    val flight: String,
    @SerializedName("gridfins")
    val gridfins: String,
    @SerializedName("landing_attempt")
    val landingAttempt: String,
    @SerializedName("landing_success")
    val landingSuccess: String,
    @SerializedName("landing_type")
    val landingType: String,
    @SerializedName("landpad")
    val landpad: String,
    @SerializedName("legs")
    val legs: String,
    @SerializedName("reused")
    val reused: String
)