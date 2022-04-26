package com.devpass.spaceapp.di

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import com.devpass.spaceapp.repository.FetchLaunchesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideFetchLaunchesRepository(spaceXAPIService: SpaceXAPIService): FetchLaunchesRepository {
        return FetchLaunchesRepositoryImpl(spaceXAPIService)
    }
}