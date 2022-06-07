package com.devpass.spaceapp.data.repository.launch

import com.devpass.spaceapp.data.model.NextLaunches

interface LaunchRepository {

    suspend fun getNextLaunches(): Result<NextLaunches>
}