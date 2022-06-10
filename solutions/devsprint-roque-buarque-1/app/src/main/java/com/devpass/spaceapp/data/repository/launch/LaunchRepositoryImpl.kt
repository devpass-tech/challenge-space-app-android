package com.devpass.spaceapp.data.repository.launch

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.model.NextLaunchModel
import com.devpass.spaceapp.data.model.NextLaunches
import com.devpass.spaceapp.data.model.OptionsRequest
import com.devpass.spaceapp.data.model.QueryRequestParams
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val service: SpaceXAPIService
): LaunchRepository {

    override suspend fun getNextLaunches(): Result<NextLaunches> {
        return try {
            val params = QueryRequestParams(options = OptionsRequest(20))
            val data = service.fetchNextLaunches(params)
            Result.success(data)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}