package com.devpass.spaceapp.data.api

import com.devpass.spaceapp.data.model.RocketModel
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.QueryRequestParams
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SpaceXAPIClient {

    //val params = QueryRequestParams(options = OptionsRequest(20))

    @POST("v5/launches/query")
    fun fetchNextLaunches(@Body params: QueryRequestParams): Call<List<NextLaunchesModel>>

    @GET("v4/rockets/{id}")
    suspend fun getRocketDetails(@Path("id") id: String): RocketModel

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
