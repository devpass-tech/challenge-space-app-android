package com.devpass.spaceapp.models

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat

data class Launch(
    @SerializedName("links")
    var image: Links,
    @SerializedName("flight_number")
    val number: Int = 0,
    @SerializedName("mission_name")
    val title: String = "",
    @SerializedName("launch_date_utc")
    val date: String = "",
    @SerializedName("launch_success")
    val status: Boolean? = false,
    @SerializedName("rocket")
    val rocketLaunch: RocketLaunch,
    @SerializedName("details")
    val details: String? = "",
)

fun Launch.formatDate(): String{
    //Informa o formato da data que está vindo da api
    val formatterApi = SimpleDateFormat("yyyy-MM-dd")
    //Transforma em um long
    val dateLong = formatterApi.parse(date.substringBefore("T"))?.time

    //Informa o formato da data que queremos
    val formated = SimpleDateFormat("MMMM dd, yyyy")
    //Formata a data como um straing
    return formated.format(dateLong)
}

data class RocketLaunch(
    @SerializedName("rocket_id")
    val rocket_id: String = ""
)

data class Links(
    @SerializedName("mission_patch_small")
    val banner: String? = ""
)