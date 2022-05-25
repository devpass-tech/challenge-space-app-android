package com.devpass.spaceapp.data.repository

import com.devpass.spaceapp.data.model.RocketModel

interface SpaceAppRepository {

    suspend fun getRocketDetails(id: String): Result<RocketModel>
}