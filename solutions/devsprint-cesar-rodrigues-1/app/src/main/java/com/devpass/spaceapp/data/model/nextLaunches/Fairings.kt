package com.devpass.spaceapp.data.model.nextLaunches


import com.google.gson.annotations.SerializedName

data class Fairings(
    @SerializedName("recovered")
    val recovered: String,
    @SerializedName("recovery_attempt")
    val recoveryAttempt: String,
    @SerializedName("reused")
    val reused: String,
    @SerializedName("ships")
    val ships: List<String>
)