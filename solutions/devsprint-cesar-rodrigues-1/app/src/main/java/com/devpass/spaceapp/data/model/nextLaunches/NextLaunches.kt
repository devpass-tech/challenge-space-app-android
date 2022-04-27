package com.devpass.spaceapp.data.model.nextLaunches


import com.google.gson.annotations.SerializedName

data class NextLaunches(
    @SerializedName("auto_update")
    val autoUpdate: Boolean,
    @SerializedName("capsules")
    val capsules: List<Any>,
    @SerializedName("cores")
    val cores: List<Core>,
    @SerializedName("crew")
    val crew: List<Any>,
    @SerializedName("date_local")
    val dateLocal: String,
    @SerializedName("date_precision")
    val datePrecision: String,
    @SerializedName("date_unix")
    val dateUnix: Int,
    @SerializedName("date_utc")
    val dateUtc: String,
    @SerializedName("details")
    val details: Any,
    @SerializedName("failures")
    val failures: List<Any>,
    @SerializedName("fairings")
    val fairings: Fairings,
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("launch_library_id")
    val launchLibraryId: String,
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
    val ships: List<Any>,
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Any,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: Any,
    @SerializedName("success")
    val success: Any,
    @SerializedName("tbd")
    val tbd: Boolean,
    @SerializedName("upcoming")
    val upcoming: Boolean,
    @SerializedName("window")
    val window: Any
)