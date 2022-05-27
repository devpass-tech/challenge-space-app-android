package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.LaunchPadModel
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.QueryRequestParams
import com.devpass.spaceapp.data.model.RocketModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpaceXAPIClient {

    @POST("v5/launches/query")
    suspend fun fetchNextLaunches(@Body params: QueryRequestParams): NextLaunchesModel

    @GET("v4/rockets/{id}")
    suspend fun getRocketDetails(@Path("id") id: String): RocketModel

    @GET("v4/launchpads/{id}")
    suspend fun getLaunchpadDetails(@Path("id") id: String): LaunchPadModel

    companion object {
        private const val BASE_URL = "https://api.spacexdata.com/"

        fun create(): SpaceXAPIClient {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(SpaceXAPIClient::class.java)
        }
    }
}