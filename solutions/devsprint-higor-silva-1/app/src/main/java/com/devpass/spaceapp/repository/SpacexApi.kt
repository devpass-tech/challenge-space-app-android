package com.devpass.spaceapp.repository

import com.devpass.spaceapp.models.Launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SpacexApi {

    @GET("launches?order=desc&limit=20")
    suspend fun getLaunchs(): Response<List<Launch>>

    companion object {
        var retrofitService: SpacexApi? = null

        fun getInstance(): SpacexApi {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.spacexdata.com/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService = retrofit.create(SpacexApi::class.java)
            }

            return retrofitService!!
        }
    }
}