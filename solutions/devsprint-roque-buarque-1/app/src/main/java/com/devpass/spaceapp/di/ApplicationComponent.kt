package com.devpass.spaceapp.di

import com.devpass.spaceapp.data.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
}