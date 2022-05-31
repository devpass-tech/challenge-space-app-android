package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.NextLaunchesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceXAPIService {
    @GET("next")
     suspend fun fetchNextLaunch() : NextLaunchesModel
}