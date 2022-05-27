package com.devpass.spaceapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.model.LaunchPadModel
import com.devpass.spaceapp.data.model.RocketModel
import com.devpass.spaceapp.data.repository.SpaceAppRepository
import kotlinx.coroutines.launch

class SpaceAppViewModel(
    private val repository: SpaceAppRepository
) : ViewModel() {

    val resultRocketDetails = MutableLiveData<RocketModel?>()
    val resultLaunchpadDetails = MutableLiveData<LaunchPadModel?>()

    fun getRocketDetails(id: String) {
        viewModelScope.launch {
            repository.getRocketDetails(id)
                .onSuccess {
                    resultRocketDetails.value = it
                }
                .onFailure {
                    resultRocketDetails.value = null
                }
        }
    }

    fun getLaunchpadDetails(id: String) {
        viewModelScope.launch {
            repository.getLaunchpadDetails(id)
                .onSuccess {
                    resultLaunchpadDetails.value = it
                }
                .onFailure {
                    resultLaunchpadDetails.value = null
                }
        }
    }
}