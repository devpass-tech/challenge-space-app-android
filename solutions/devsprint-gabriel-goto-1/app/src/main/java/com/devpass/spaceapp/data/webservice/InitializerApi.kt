package com.devpass.spaceapp.data.webservice

import com.devpass.spaceapp.data.api.SpaceXAPIClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InitializerApi {

    private const val BASE_URL = "https://api.spacexdata.com/"

    fun create(): SpaceXAPIClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(SpaceXAPIClient::class.java)
    }
}