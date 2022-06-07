package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.NextLaunchModel
import com.devpass.spaceapp.data.model.Launchpad
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceXAPIService {
    @GET("next")
    suspend fun fetchNextLaunch() : NextLaunchModel

    @GET("launchpads")
    suspend fun fetchLaunchPadDetails(@Query("id") id: String) : Launchpad
}