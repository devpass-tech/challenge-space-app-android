package com.devpass.spaceapp.repository

class Repository(private val service: SpacexApi) {

    suspend fun getLaunchs() = service.getLaunchs()
}