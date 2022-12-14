package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName

data class LaunchpadId(
    @SerializedName("site_id")
    val id: String = ""
)