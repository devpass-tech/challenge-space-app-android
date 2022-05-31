package com.devpass.spaceapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Network {

    private fun retrofitInstance(): Retrofit {

        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("BASE_URL")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun createSpaceXService () : SpaceXAPIService {
        return retrofitInstance().create()
    }
}