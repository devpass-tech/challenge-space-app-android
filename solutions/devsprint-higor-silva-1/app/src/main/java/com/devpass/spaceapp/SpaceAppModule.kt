package com.devpass.spaceapp

import com.devpass.spaceapp.repository.SpacexApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SpaceAppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): SpacexApi {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(SpacexApi::class.java)
    }

}