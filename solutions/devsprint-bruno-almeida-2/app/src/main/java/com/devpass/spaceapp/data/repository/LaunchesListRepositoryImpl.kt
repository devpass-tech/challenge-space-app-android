package com.devpass.spaceapp.data.repository

import com.devpass.spaceapp.data.datasource.LaunchesListDataSourceImpl
import com.devpass.spaceapp.data.model.LaunchesResponse
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.QueryParams

class LaunchesListRepositoryImpl (
    private val launchesListDataSourceImpl: LaunchesListDataSourceImpl
){
    suspend fun fetchNextLaunches(params: QueryParams): Result<List<NextLaunchesModel>> {
        return handleResult(launchesListDataSourceImpl.fetchNextLaunches(params).docs)
    }
    private fun handleResult(fetchNextLaunches: List<NextLaunchesModel>): Result<List<NextLaunchesModel>> {
        return try {
            Result.success(fetchNextLaunches)
        } catch (e: java.lang.Exception){
            Result.failure(e)
        }
    }
}