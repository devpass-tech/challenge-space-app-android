package com.devpass.spaceapp.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val service: SpacexApi) {

    suspend fun getLaunches() = service.getLaunches()
}