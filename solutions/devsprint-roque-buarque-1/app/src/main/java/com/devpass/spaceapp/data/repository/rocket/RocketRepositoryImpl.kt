package com.devpass.spaceapp.data.repository.rocket

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.model.DRocketDetail
import javax.inject.Inject

class RocketRepositoryImpl @Inject constructor(
    private val spaceXAPIService: SpaceXAPIService
): RocketRepository {

    override suspend fun fetchRocketDetails(rocketId: Int): DRocketDetail {
        return spaceXAPIService.fetchRocketDetails(rocketId)
    }
}