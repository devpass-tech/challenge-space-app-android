package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.model.launch.LaunchModel
import com.devpass.spaceapp.data.model.nextLaunches.NextLaunches
import kotlinx.coroutines.flow.Flow

interface FetchLaunchesRepository {
    suspend fun fetchLaunches(): Flow<LaunchModel>

    suspend fun fetchNextLaunches(): Flow<NextLaunches>
}