package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class DRocketDetail(@SerializedName("second_stage")
                         val secondStage: SecondStage,
                         @SerializedName("country")
                         val country: String = "",
                         @SerializedName("mass")
                         val mass: Mass,
                         @SerializedName("active")
                         val active: Boolean = false,
                         @SerializedName("cost_per_launch")
                         val costPerLaunch: Int = 0,
                         @SerializedName("description")
                         val description: String = "",
                         @SerializedName("type")
                         val type: String = "",
                         @SerializedName("payload_weights")
                         val payloadWeights: List<PayloadWeightsItem>?,
                         @SerializedName("first_flight")
                         val firstFlight: String = "",
                         @SerializedName("landing_legs")
                         val landingLegs: LandingLegs,
                         @SerializedName("diameter")
                         val diameter: Diameter,
                         @SerializedName("flickr_images")
                         val flickrImages: List<String>?,
                         @SerializedName("first_stage")
                         val firstStage: FirstStage,
                         @SerializedName("engines")
                         val engines: Engines,
                         @SerializedName("name")
                         val name: String = "",
                         @SerializedName("stages")
                         val stages: Int = 0,
                         @SerializedName("boosters")
                         val boosters: Int = 0,
                         @SerializedName("company")
                         val company: String = "",
                         @SerializedName("success_rate_pct")
                         val successRatePct: Int = 0,
                         @SerializedName("wikipedia")
                         val wikipedia: String = "",
                         @SerializedName("id")
                         val id: String = "",
                         @SerializedName("height")
                         val height: Height)