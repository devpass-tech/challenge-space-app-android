package com.devpass.spaceapp.repository

import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.LaunchpadDetails
import com.devpass.spaceapp.models.RocketDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpacexApi {

    @GET("launches?order=desc")
    suspend fun getLaunches(@Query("limit") quantLaunches: Int): Response<List<Launch>>

    @GET("launchpads/{launchpadId}")
    suspend fun getLaunchpadDetails(@Path("launchpadId") launchpadId: String): Response<LaunchpadDetails>

    @GET("rockets/{rocketId}")
    suspend fun getRocketDetails(@Path("rocketId") rocketId: String): Response<RocketDetails>
}