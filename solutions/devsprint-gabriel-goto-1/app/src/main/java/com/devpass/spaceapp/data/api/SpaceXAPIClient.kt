package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.LaunchPage
import com.devpass.spaceapp.data.model.QueryParams
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SpaceXAPIService {

    @POST("v5/launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryParams): LaunchPage
}