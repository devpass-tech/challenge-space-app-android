package com.devpass.spaceapp.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val service: SpacexApi) {

    suspend fun getLaunches(quantLaunches: Int) = service.getLaunches(quantLaunches)
    suspend fun getRocketDetails(rocketId: String) = service.getRocketDetails(rocketId)
    suspend fun getLaunchpadDetails(launchpadId: String) = service.getLaunchpadDetails(launchpadId)
}