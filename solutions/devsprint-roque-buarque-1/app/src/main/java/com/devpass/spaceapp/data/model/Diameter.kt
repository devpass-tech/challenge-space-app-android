package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Diameter(@SerializedName("feet")
                    val feet: Double = 0.0,
                    @SerializedName("meters")
                    val meters: Double = 0.0)