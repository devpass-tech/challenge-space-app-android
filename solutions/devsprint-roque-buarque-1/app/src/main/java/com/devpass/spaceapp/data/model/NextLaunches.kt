package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NextLaunches(
    @SerializedName("docs")
    val launches: List<NextLaunchesItem>
): Serializable

