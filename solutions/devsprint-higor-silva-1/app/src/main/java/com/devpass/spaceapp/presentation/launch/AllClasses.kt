package com.devpass.spaceapp.presentation.launch

import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.Rocket
import com.devpass.spaceapp.models.Launchpad

data class AllClasses(
    var launch: Launch? = null,
    var rocket: Rocket? = null,
    var launchpad: Launchpad? = null
)