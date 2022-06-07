package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class ThrustVacuum(@SerializedName("lbf")
                        val lbf: Int = 0,
                        @SerializedName("kN")
                        val kN: Int = 0)