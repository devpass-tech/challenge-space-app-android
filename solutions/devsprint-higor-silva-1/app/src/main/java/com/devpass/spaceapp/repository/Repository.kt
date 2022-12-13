package com.devpass.spaceapp.repository

class Repository(private val service: SpacexApi) {

    suspend fun getLaunches() = service.getLaunches()
}