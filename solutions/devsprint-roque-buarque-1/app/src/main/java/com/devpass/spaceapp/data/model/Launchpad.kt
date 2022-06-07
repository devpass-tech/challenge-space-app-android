package com.devpass.spaceapp.data.model

data class Launchpad(
    val name: String,
    val locality: String,
    val region: String,
    val launch_attempts: Int,
    val launch_successes: Int
)
