package com.devpass.spaceapp.data.model.nextLaunches


import com.google.gson.annotations.SerializedName

data class Core(
    @SerializedName("core")
    val core: Any,
    @SerializedName("flight")
    val flight: Any,
    @SerializedName("gridfins")
    val gridfins: Any,
    @SerializedName("landing_attempt")
    val landingAttempt: Any,
    @SerializedName("landing_success")
    val landingSuccess: Any,
    @SerializedName("landing_type")
    val landingType: Any,
    @SerializedName("landpad")
    val landpad: Any,
    @SerializedName("legs")
    val legs: Any,
    @SerializedName("reused")
    val reused: Any
)