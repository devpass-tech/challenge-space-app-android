package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.DRocketDetail
import com.devpass.spaceapp.data.model.NextLaunchModel
import com.devpass.spaceapp.data.model.NextLaunches
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpaceXAPIService {

    @POST("query")
    suspend fun fetchNextLaunches() : NextLaunches

    @GET("next")
    suspend fun fetchNextLaunch() : NextLaunchModel

    @GET("v4/rockets/{rocketId}")
    suspend fun fetchRocketDetails(@Path("rocketId") rocketId: Int) : DRocketDetail

}