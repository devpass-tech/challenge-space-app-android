package com.devpass.spaceapp.repository

import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.Launchpad
import com.devpass.spaceapp.models.Rocket
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SpacexApi {

    @GET("launches?order=desc&limit=20")
    suspend fun getLaunches(): Response<List<Launch>>

    @GET("launchpads/{launchpadId}")
    suspend fun getSpecificLaunch(@Path("launchpadId") launchpadId: String): Response<Launchpad>

    @GET("rockets/{rocketId}")
    suspend fun getSpecificRocket(@Path("rocketId") rocketId: String): Response<Rocket>
}