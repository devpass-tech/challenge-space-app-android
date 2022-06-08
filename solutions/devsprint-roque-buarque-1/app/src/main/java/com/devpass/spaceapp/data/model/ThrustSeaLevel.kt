package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class ThrustSeaLevel(@SerializedName("lbf")
                          val lbf: Int = 0,
                          @SerializedName("kN")
                          val kN: Int = 0)