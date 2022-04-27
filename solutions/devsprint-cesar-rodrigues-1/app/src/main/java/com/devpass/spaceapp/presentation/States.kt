package com.devpass.spaceapp.presentation

import com.devpass.spaceapp.data.model.launch.LaunchModel

abstract class States {
    sealed class LaunchStates {
        object Loading : LaunchStates()
        data class Success(val launches: LaunchModel) : LaunchStates()
        data class Failure(val failure: String?) : LaunchStates()
    }
}
