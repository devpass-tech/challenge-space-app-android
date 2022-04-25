package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.model.LaunchModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchLaunchesRepositoryImpl @Inject constructor(private val spaceXAPIService: SpaceXAPIService) :
    FetchLaunchesRepository {
    override suspend fun fetchNextLaunches(): Flow<LaunchModel> = flow {
        emit(spaceXAPIService.fetchNextLaunches())
    }
}