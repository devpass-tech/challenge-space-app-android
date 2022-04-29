package com.devpass.spaceapp.data.model.nextLaunches


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("article")
    val article: String,
    @SerializedName("flickr")
    val flickr: Flickr,
    @SerializedName("patch")
    val patch: Patch,
    @SerializedName("presskit")
    val presskit: String,
    @SerializedName("reddit")
    val reddit: Reddit,
    @SerializedName("webcast")
    val webcast: String,
    @SerializedName("wikipedia")
    val wikipedia: String,
    @SerializedName("youtube_id")
    val youtubeId: String
)