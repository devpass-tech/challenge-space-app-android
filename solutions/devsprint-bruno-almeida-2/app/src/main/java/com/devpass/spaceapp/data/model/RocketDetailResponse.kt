package com.devpass.spaceapp.data.model

import java.io.Serializable

data class RocketDetailResponse(
    val id: String,
    val name: String,
    val flickr_images: List<String>,
    val description: String
) : Serializable