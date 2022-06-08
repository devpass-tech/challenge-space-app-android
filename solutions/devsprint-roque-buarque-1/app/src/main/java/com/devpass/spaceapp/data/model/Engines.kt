package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Engines(@SerializedName("layout")
                   val layout: String = "",
                   @SerializedName("number")
                   val number: Int = 0,
                   @SerializedName("propellant_1")
                   val propellant: String = "",
                   @SerializedName("thrust_sea_level")
                   val thrustSeaLevel: ThrustSeaLevel,
                   @SerializedName("engine_loss_max")
                   val engineLossMax: Int = 0,
                   @SerializedName("thrust_to_weight")
                   val thrustToWeight: Double = 0.0,
                   @SerializedName("thrust_vacuum")
                   val thrustVacuum: ThrustVacuum,
                   @SerializedName("isp")
                   val isp: Isp,
                   @SerializedName("type")
                   val type: String = "",
                   @SerializedName("version")
                   val version: String = "",
                   @SerializedName("propellant_2")
                   val propellant2: String = "")