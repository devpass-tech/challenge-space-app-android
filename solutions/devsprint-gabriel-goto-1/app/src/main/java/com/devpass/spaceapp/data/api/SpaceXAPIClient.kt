package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.LaunchPageResponse
import com.devpass.spaceapp.data.model.QueryParams
import retrofit2.http.Body
import retrofit2.http.POST

interface SpaceXAPIClient {

    @POST("v5/launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryParams): LaunchPageResponse
}