package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.model.launch.LaunchModel
import com.devpass.spaceapp.data.model.nextLaunches.NextLaunches
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchLaunchesRepositoryImpl @Inject constructor(private val spaceXAPIService: SpaceXAPIService) :
    FetchLaunchesRepository {
    override suspend fun fetchLaunches(): Flow<LaunchModel> = flow {
        emit(spaceXAPIService.fetchLaunches())
    }

    override suspend fun fetchNextLaunches(): Flow<NextLaunches> = flow{
        emit(spaceXAPIService.fetchNextLaunches())
    }
}