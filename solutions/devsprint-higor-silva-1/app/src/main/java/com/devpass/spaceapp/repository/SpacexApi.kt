package com.devpass.spaceapp.repository

import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.Rocket
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SpacexApi {

    @GET("launches?order=desc&limit=20")
    suspend fun getLaunchs(): Response<List<Launch>>

    @GET("rockets/{rocketId}")
    suspend fun getRocket(@Path("rocketId") rocketId: String): Response<Rocket>
}