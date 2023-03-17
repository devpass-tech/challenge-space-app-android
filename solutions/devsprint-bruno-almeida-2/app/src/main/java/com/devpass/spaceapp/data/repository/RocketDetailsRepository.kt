package com.devpass.spaceapp.data.repository

import com.devpass.spaceapp.data.datasource.RocketDetailsDataSource
import com.devpass.spaceapp.data.model.RocketDetailResponse

class RocketDetailsRepository(private val rocketDetailsDataSource: RocketDetailsDataSource) {

    suspend fun getRocketDetails(id:String): Result<RocketDetailResponse>{
        return handleResult(rocketDetailsDataSource.getRocketDetails(id))
    }

    private fun handleResult(rocketDetails: RocketDetailResponse): Result<RocketDetailResponse> {
        return try {
            Result.success(rocketDetails)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}