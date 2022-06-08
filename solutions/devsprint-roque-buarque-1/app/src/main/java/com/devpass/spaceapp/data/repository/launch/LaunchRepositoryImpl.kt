package com.devpass.spaceapp.data.repository.launch

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.model.NextLaunchModel
import com.devpass.spaceapp.data.model.NextLaunches
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val service: SpaceXAPIService
): LaunchRepository {

    override suspend fun getNextLaunches(): Result<NextLaunches> {
        return try {
            val data = service.fetchNextLaunches()
            Result.success(data)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}