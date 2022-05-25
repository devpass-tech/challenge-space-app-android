package com.devpass.spaceapp.di

import com.devpass.spaceapp.data.api.SpaceXAPIClient
import com.devpass.spaceapp.data.repository.SpaceAppRepository
import com.devpass.spaceapp.data.repository.SpaceAppRepositoryImpl
import com.devpass.spaceapp.presentation.SpaceAppViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val spaceModule = module {
    factory<SpaceAppRepository> { SpaceAppRepositoryImpl(SpaceXAPIClient.create()) }
    viewModel { SpaceAppViewModel(get()) }
}