package com.devpass.spaceapp.data.repository.launch

interface LaunchRepository {

    suspend fun getData(): List<String>
}