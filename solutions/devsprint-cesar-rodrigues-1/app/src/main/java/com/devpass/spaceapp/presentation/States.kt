package com.devpass.spaceapp.presentation

import com.devpass.spaceapp.data.model.LaunchModel

sealed class States {
    object Loading : States()
    data class Success(val launches: LaunchModel) : States()
    data class Failure(val failure: String?) : States()
}
