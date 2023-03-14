package com.devpass.spaceapp.data.datasource

import com.devpass.spaceapp.data.api.SpaceXAPIClient
import com.devpass.spaceapp.data.model.LaunchesResponse
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.QueryParams

class LaunchesListDataSourceImpl(
    private val service: SpaceXAPIClient
) {
    suspend fun fetchNextLaunches(params: QueryParams) : LaunchesResponse {
        return  service.fetchNextLaunches(params = params)
    }
}