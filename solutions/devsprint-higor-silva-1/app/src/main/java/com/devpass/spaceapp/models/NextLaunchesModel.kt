package com.devpass.spaceapp.models

import java.io.Serializable

data class NextLaunchesModel(
    val image: Int,
    val title: String,
    val subtitle: String,
    val status: String,
    val position: String
): Serializable

