package com.devpass.spaceapp.data.repository

import com.devpass.spaceapp.data.datasource.LaunchesListDataSourceImpl
import com.devpass.spaceapp.data.model.LaunchesResponse
import com.devpass.spaceapp.data.model.QueryParams

class LaunchesListRepositoryImpl (
    private val launchesListDataSourceImpl: LaunchesListDataSourceImpl
) {
    suspend fun fetchNextLaunches(params: QueryParams): LaunchesResponse{
        return launchesListDataSourceImpl.fetchNextLaunches(params)
    }
}