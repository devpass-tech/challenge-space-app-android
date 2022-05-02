package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.launch.LaunchModel
import com.devpass.spaceapp.data.model.nextLaunches.NextLaunches
import retrofit2.http.GET
import retrofit2.http.POST

interface SpaceXAPIService {
    @POST("launchpads/query")
    suspend fun fetchLaunches(): LaunchModel

    @GET("launches/next")
    suspend fun fetchNextLaunches(): NextLaunches
}