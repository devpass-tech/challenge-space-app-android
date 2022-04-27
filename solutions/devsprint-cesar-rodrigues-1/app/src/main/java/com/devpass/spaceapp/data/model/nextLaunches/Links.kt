package com.devpass.spaceapp.data.model.nextLaunches


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("article")
    val article: Any,
    @SerializedName("flickr")
    val flickr: Flickr,
    @SerializedName("patch")
    val patch: Patch,
    @SerializedName("presskit")
    val presskit: Any,
    @SerializedName("reddit")
    val reddit: Reddit,
    @SerializedName("webcast")
    val webcast: Any,
    @SerializedName("wikipedia")
    val wikipedia: Any,
    @SerializedName("youtube_id")
    val youtubeId: Any
)