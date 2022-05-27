package com.devpass.spaceapp.data.repository

import com.devpass.spaceapp.data.api.SpaceXAPIClient
import com.devpass.spaceapp.data.model.LaunchPadModel
import com.devpass.spaceapp.data.model.RocketModel

class SpaceAppRepositoryImpl(
    private val service: SpaceXAPIClient
) : SpaceAppRepository {

    override suspend fun getRocketDetails(id: String): Result<RocketModel> {
        return try {
            val result = service.getRocketDetails(id)
            Result.success(result)
        } catch (error: Exception) {
            Result.failure(error)
        }
    }

    override suspend fun getLaunchpadDetails(id: String): Result<LaunchPadModel> {
        return try {
            val result = service.getLaunchpadDetails(id)
            Result.success(result)
        } catch (error: Exception) {
            Result.failure(error)
        }
    }
}