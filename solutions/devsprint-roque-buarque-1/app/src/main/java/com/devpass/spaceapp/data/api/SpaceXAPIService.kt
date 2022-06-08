package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.DRocketDetail
import com.devpass.spaceapp.data.model.NextLaunchModel
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXAPIService {

    @GET("next")
    suspend fun fetchNextLaunch() : NextLaunchModel

/*    @Post("query")
    suspend fun fetchNextLaunches() : NextLauches*/

    @GET("v4/rockets/{rocketId}")
    suspend fun fetchRocketDetails(@Path("rocketId") rocketId: Int) : DRocketDetail
}