package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("patch")
    val patch: Patch,
)

data class Patch(
    @SerializedName("small")
    val small: String,
    @SerializedName("large")
    val large: String,
)
