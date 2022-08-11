package com.devpass.spaceapp.data.webservice

import com.devpass.spaceapp.BuildConfig
import com.devpass.spaceapp.data.api.SpaceXAPIClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InitializerApi {

        private val retrofit by lazy {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            Retrofit.Builder()
                .baseUrl(BuildConfig.SPACEX_API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    fun getSpaceAPI() = retrofit.create(SpaceXAPIClient::class.java)
}