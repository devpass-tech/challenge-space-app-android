package com.devpass.spaceapp.data.model

import java.io.Serializable

data class RocketModel(
    val number : Int,
    val name : String,
    val date : Int,
    val status : Boolean,
    val image: String
    ): Serializable

