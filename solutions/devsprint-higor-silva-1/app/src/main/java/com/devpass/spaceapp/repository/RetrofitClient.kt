package com.devpass.spaceapp.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val client: SpacexApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(SpacexApi::class.java)
    }
}