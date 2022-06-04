package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.NextLaunchModel
import retrofit2.http.GET

interface SpaceXAPIService {
    @GET("next")
     suspend fun fetchNextLaunch() : NextLaunchModel
}