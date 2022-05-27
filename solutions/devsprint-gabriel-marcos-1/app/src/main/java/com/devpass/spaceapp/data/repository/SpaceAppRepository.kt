package com.devpass.spaceapp.data.repository

import com.devpass.spaceapp.data.model.LaunchPadModel
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.RocketModel

interface SpaceAppRepository {

    suspend fun getRocketDetails(id: String): Result<RocketModel>
    suspend fun getLaunchpadDetails(id: String): Result<LaunchPadModel>
    suspend fun fetchNextLaunches(number_rockets: Int): Result<NextLaunchesModel>
}