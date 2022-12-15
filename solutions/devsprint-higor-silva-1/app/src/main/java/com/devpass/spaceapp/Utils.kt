package com.devpass.spaceapp

import android.content.Context
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.LaunchpadDetails
import com.devpass.spaceapp.models.Location
import com.devpass.spaceapp.models.RocketDetails
import com.google.android.gms.maps.model.LatLng
import java.text.SimpleDateFormat

fun Launch.formatDate(): String {
    //Informa o formato da data que está vindo da api
    val formatterApi = SimpleDateFormat("yyyy-MM-dd")
    //Transforma em um long
    val dateLong = formatterApi.parse(date.substringBefore("T"))?.time

    //Informa o formato da data que queremos
    val formated = SimpleDateFormat("MMMM dd, yyyy")
    //Formata a data como um string
    return formated.format(dateLong)
}

fun Launch.getImgLink() =
    image.banner ?: "https://dummyimage.com/400x400/000/fff"

fun Launch.getStatus(context: Context) =
    status?.let {
        if (it) context.getString(R.string.success)
        else context.getString(R.string.fail)
    } ?: context.getString(R.string.uknown)

fun Location.getLatLng() = LatLng(latitude, longitude)

fun Launch.setRocket(rocketDetails: RocketDetails): Launch =
    this.copy(rocketDetails = rocketDetails)

fun Launch.setLaunchpad(launchpad: LaunchpadDetails): Launch =
    this.copy(launchpadDetails = launchpad)