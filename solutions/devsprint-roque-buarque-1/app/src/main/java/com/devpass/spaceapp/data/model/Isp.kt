package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Isp(@SerializedName("vacuum")
               val vacuum: Int = 0,
               @SerializedName("sea_level")
               val seaLevel: Int = 0)