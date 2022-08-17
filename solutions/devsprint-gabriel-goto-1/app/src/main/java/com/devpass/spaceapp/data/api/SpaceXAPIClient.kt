package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.LaunchPadDetailsResponse
import com.devpass.spaceapp.data.model.LaunchPageResponse
import com.devpass.spaceapp.data.model.QueryParams
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpaceXAPIClient {

    @POST("launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryParams): LaunchPageResponse

    @GET("v4/launchpads/{id}")
    suspend fun fetchLaunchpadDetails(@Path("id") id: String): LaunchPadDetailsResponse
}