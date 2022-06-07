package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.NextLaunchModel
import com.devpass.spaceapp.data.model.NextLaunches
import retrofit2.http.GET
import retrofit2.http.POST

interface SpaceXAPIService {

    @GET("next")
    suspend fun fetchNextLaunch() : NextLaunchModel

    @POST("query")
    suspend fun fetchNextLaunches() : NextLaunches

}