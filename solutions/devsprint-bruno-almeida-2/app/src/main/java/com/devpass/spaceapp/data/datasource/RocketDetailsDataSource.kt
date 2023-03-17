package com.devpass.spaceapp.data.datasource

import com.devpass.spaceapp.data.api.RocketdetailAPIClient
import com.devpass.spaceapp.data.model.RocketDetailResponse

class RocketDetailsDataSource(private val rocketdetailAPIClient: RocketdetailAPIClient) {
    suspend fun getRocketDetails(id: String) : RocketDetailResponse {
        return rocketdetailAPIClient.getRocketDetails(id)
    }
}