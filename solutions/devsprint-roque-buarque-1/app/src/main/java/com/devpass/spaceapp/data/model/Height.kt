package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Height(@SerializedName("feet")
                  val feet: Double = 0.0,
                  @SerializedName("meters")
                  val meters: Int = 0)