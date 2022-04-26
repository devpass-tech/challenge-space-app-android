package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.model.LaunchModel
import kotlinx.coroutines.flow.Flow

interface FetchLaunchesRepository {
    suspend fun fetchNextLaunches(): Flow<LaunchModel>
}