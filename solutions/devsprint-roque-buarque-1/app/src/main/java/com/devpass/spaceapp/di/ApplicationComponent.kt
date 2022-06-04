package com.devpass.spaceapp.di

import com.devpass.spaceapp.data.network.NetworkModule
import com.devpass.spaceapp.presentation.di.ViewModelModule
import com.devpass.spaceapp.presentation.launch.LaunchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, LaunchBinding::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: LaunchActivity)
}