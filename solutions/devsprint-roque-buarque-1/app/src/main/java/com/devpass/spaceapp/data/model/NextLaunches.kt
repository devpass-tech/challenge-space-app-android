package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName


data class NextLaunches (

    @SerializedName("docs")
    val launches: List<NextLauchesItem>

    )