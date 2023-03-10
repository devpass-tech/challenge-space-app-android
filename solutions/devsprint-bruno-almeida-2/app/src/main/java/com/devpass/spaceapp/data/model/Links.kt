package com.devpass.spaceapp.data.model

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("article")
    val article: String,
    @SerializedName("flickr")
    val flickr: ImageRocket,
    @SerializedName("patch")
    val image: ImageIcon,
    @SerializedName("presskit")
    val presskit: String,
    @SerializedName("webcast")
    val webcast: String,
    @SerializedName("wikipedia")
    val wikipedia: String,
    @SerializedName("youtube_id")
    val youtube_id: String
)