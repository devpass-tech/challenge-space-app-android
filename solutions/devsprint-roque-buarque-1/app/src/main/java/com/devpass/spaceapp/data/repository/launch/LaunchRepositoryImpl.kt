package com.devpass.spaceapp.data.repository.launch

import com.devpass.spaceapp.data.api.SpaceXAPIService
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val service: SpaceXAPIService
): LaunchRepository {

    override suspend fun getData() {
        TODO("Not yet implemented")
    }
}