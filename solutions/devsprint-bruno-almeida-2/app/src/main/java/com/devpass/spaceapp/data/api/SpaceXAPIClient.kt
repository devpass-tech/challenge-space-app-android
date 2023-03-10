package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.LaunchesResponse
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.QueryParams
import retrofit2.http.Body
import retrofit2.http.POST

interface SpaceXAPIClient {
    @POST("launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryParams ) : LaunchesResponse
}