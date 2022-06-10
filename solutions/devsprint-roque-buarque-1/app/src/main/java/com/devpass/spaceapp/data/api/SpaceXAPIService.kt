package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.DRocketDetail
import com.devpass.spaceapp.data.model.NextLaunchModel
import com.devpass.spaceapp.data.model.NextLaunches
import com.devpass.spaceapp.data.model.QueryRequestParams
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpaceXAPIService {

    @GET("next")
    suspend fun fetchNextLaunch() : NextLaunchModel

    @POST("v5/launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryRequestParams): NextLaunches

    @GET("v4/rockets/{rocketId}")
    suspend fun fetchRocketDetails(@Path("rocketId") rocketId: Int) : DRocketDetail
}