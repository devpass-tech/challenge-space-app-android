package com.devpass.spaceapp.repository

import com.devpass.spaceapp.models.Launch
import retrofit2.Response
import retrofit2.http.GET

interface SpacexApi {

    @GET("launches?order=desc&limit=20")
    suspend fun getLaunches(): Response<List<Launch>>

}