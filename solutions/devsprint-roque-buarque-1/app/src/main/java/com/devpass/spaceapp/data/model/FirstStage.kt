package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class FirstStage(@SerializedName("thrust_sea_level")
                      val thrustSeaLevel: ThrustSeaLevel,
                      @SerializedName("fuel_amount_tons")
                      val fuelAmountTons: Int = 0,
                      @SerializedName("thrust_vacuum")
                      val thrustVacuum: ThrustVacuum,
                      @SerializedName("engines")
                      val engines: Int = 0,
                      @SerializedName("burn_time_sec")
                      val burnTimeSec: Int = 0,
                      @SerializedName("reusable")
                      val reusable: Boolean = false)