package com.devpass.spaceapp.di

import com.devpass.spaceapp.data.repository.rocket.RocketRepository
import com.devpass.spaceapp.data.repository.rocket.RocketRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RocketBinding {

    @Singleton
    @Binds
    fun provideRocketRepository(impl: RocketRepositoryImpl): RocketRepository
}