package com.devpass.spaceapp.data.repository

import com.devpass.spaceapp.data.api.Network
import com.devpass.spaceapp.data.api.SpaceXAPIService


class NextLaunchRepository private constructor(val service: SpaceXAPIService) {
    companion object {
        fun newInstance(): NextLaunchRepository {
            return NextLaunchRepository(Network.createSpaceXService())
        }
    }
}