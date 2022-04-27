package com.devpass.spaceapp.data.model.nextLaunches


import com.google.gson.annotations.SerializedName

data class Fairings(
    @SerializedName("recovered")
    val recovered: Any,
    @SerializedName("recovery_attempt")
    val recoveryAttempt: Any,
    @SerializedName("reused")
    val reused: Any,
    @SerializedName("ships")
    val ships: List<Any>
)