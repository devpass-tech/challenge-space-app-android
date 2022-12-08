package com.devpass.spaceapp.models

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel
data class NextLaunchesModel(
    val image: Int,
    val title: String,
    val subtitle: String,
    val status: String,
    val position: String
){
    @ParcelConstructor constructor(): this(0, "", "", "", "")
}

