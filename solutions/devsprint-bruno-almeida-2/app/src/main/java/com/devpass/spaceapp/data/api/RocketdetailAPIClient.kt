package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.RocketDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RocketdetailAPIClient {

    @GET("rockets")
    suspend fun getRocketDetails(@Query("id") id: String): RocketDetailResponse
}