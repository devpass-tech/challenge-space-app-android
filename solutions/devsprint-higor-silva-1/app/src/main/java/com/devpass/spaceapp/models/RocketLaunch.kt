package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName

data class RocketLaunch(
    @SerializedName("rocket_id")
    val rocket_id: String = ""
)