package com.devpass.spaceapp.data.model

import java.io.Serializable

class LaunchpadModel(
    val number : Int,
    val name : String,
    val date : Int,
    val status : Boolean,
    val image: String
): Serializable
