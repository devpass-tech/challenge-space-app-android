package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class SecondStage(@SerializedName("fuel_amount_tons")
                       val fuelAmountTons: Int = 0,
                       @SerializedName("payloads")
                       val payloads: Payloads,
                       @SerializedName("engines")
                       val engines: Int = 0,
                       @SerializedName("burn_time_sec")
                       val burnTimeSec: Int = 0,
                       @SerializedName("thrust")
                       val thrust: Thrust,
                       @SerializedName("reusable")
                       val reusable: Boolean = false)