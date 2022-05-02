package com.devpass.spaceapp.data.model.launch


import com.google.gson.annotations.SerializedName

data class LaunchModel(
    @SerializedName("docs")
    val docs: List<DocModel>,
    @SerializedName("hasNextPage")
    val hasNextPage: Boolean,
    @SerializedName("hasPrevPage")
    val hasPrevPage: Boolean,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("nextPage")
    val nextPage: Any,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("pagingCounter")
    val pagingCounter: Int,
    @SerializedName("prevPage")
    val prevPage: Any,
    @SerializedName("totalDocs")
    val totalDocs: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)