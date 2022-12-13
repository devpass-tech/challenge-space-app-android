package com.devpass.spaceapp.repository

import javax.inject.Inject

class Repository @Inject constructor(private val service: SpacexApi) {

    suspend fun getLaunches() = service.getLaunches()
}