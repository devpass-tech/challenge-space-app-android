package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Fairings(
    @SerializedName("recovered")
    val recovered: Boolean,
    @SerializedName("recovery_attempt")
    val recovery_attempt: Boolean,
    @SerializedName("reused")
    val reused: Boolean,
    @SerializedName("ships")
    val ships: List<String>
)