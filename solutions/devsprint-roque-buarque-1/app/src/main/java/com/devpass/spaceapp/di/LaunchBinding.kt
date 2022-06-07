package com.devpass.spaceapp.di

import com.devpass.spaceapp.data.repository.launch.LaunchRepository
import com.devpass.spaceapp.data.repository.launch.LaunchRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface LaunchBinding {

    @Singleton
    @Binds
    fun provideLaunchRepository(impl: LaunchRepositoryImpl): LaunchRepository
}