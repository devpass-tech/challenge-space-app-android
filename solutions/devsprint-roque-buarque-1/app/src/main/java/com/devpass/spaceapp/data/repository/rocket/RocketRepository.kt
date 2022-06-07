package com.devpass.spaceapp.data.repository.rocket

import com.devpass.spaceapp.data.model.DRocketDetail

interface RocketRepository {

    suspend fun fetchRocketDetails(rocketId: Int): DRocketDetail
}