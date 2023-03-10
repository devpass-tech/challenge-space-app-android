package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Core(
    @SerializedName("core")
    val core: String,
    @SerializedName("flight")
    val flight: Int,
    @SerializedName("gridfins")
    val gridfins: Boolean,
    @SerializedName("landing_attempt")
    val landing_attempt: Boolean,
    @SerializedName("landing_success")
    val landing_success: Boolean,
    @SerializedName("landing_type")
    val landing_type: String,
    @SerializedName("landpad")
    val landpad: String,
    @SerializedName("legs")
    val legs: Boolean,
    @SerializedName("reused")
    val reused: Boolean
)