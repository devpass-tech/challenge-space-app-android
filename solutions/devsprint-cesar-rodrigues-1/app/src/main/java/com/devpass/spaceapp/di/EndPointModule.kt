package com.devpass.spaceapp.di

import com.devpass.spaceapp.data.api.SpaceXAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class EndPointModule {
    @Singleton
    @Provides
    fun provideSpaceXAPIService(retrofit: Retrofit): SpaceXAPIService {
        return retrofit.create(SpaceXAPIService::class.java)
    }
}