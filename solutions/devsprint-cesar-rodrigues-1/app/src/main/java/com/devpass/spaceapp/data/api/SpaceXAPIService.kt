package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.LaunchModel
import retrofit2.http.POST

interface SpaceXAPIService {
    @POST("launchpads/query")
    suspend fun fetchNextLaunches(): LaunchModel
}