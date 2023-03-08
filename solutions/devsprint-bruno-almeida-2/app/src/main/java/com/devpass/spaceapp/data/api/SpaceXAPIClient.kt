package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.NextLaunchesModel
import retrofit2.http.GET
import retrofit2.http.POST

interface SpaceXAPIClient {
    @POST("launches/query")
    suspend fun fetchNextLaunches():NextLaunchesModel
}