package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class NextLaunchesModel(
    @SerializedName("auto_update")
    val auto_update: Boolean,
    @SerializedName("capsules")
    val capsules: List<String>,
    @SerializedName("cores")
    val cores: List<Core>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("date_local")
    val date_local: String,
    @SerializedName("date_precision")
    val date_precision: String,
    @SerializedName("date_unix")
    val date_unix: Int,
    @SerializedName("date_utc")
    val date_utc: String,
    @SerializedName("details")
    val details: String,
    @SerializedName("failures")
    val failures: List<Failure>,
    @SerializedName("fairings")
    val fairings: Fairings,
    @SerializedName("flight_number")
    val flight_number: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("launch_library_id")
    val launch_library_id: String,
    @SerializedName("launchpad")
    val launchpad: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("name")
    val name: String,
    @SerializedName("net")
    val net: Boolean,
    @SerializedName("payloads")
    val payloads: List<String>,
    @SerializedName("rocket")
    val rocket: String,
    @SerializedName("ships")
    val ships: List<String>,
    @SerializedName("static_fire_date_unix")
    val static_fire_date_unix: Int,
    @SerializedName("static_fire_date_utc")
    val static_fire_date_utc: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("tdb")
    val tbd: Boolean,
    @SerializedName("upcoming")
    val upcoming: Boolean,
    @SerializedName("window")
    val window: Int
)