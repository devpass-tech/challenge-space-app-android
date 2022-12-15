package com.devpass.spaceapp.presentation.launch

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.LaunchpadDetails
import com.devpass.spaceapp.models.RocketDetails
import com.devpass.spaceapp.repository.Repository
import com.devpass.spaceapp.setLaunchpad
import com.devpass.spaceapp.setRocket
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    lateinit var launch: Launch
    private val errorMessage = MutableLiveData<String>()

    private val selectedRocketDetails = MutableLiveData<RocketDetails>()
    private val selectedLaunchpadDetails = MutableLiveData<LaunchpadDetails>()

    val isDetailsFinished: MediatorLiveData<Launch> = MediatorLiveData<Launch>().apply {
        addSource(selectedRocketDetails) { value ->
            run {
                launch = launch.setRocket(value)
                this.value = launch
            }
        }
        addSource(selectedLaunchpadDetails) { value ->
            run {
                launch = launch.setLaunchpad(value)
                this.value = launch
            }
        }
    }

    fun getLaunchDetails(launch: Launch) {
        this.launch = launch
        getRocket(launch.rocketLaunch.rocket_id)
        getLaunchpad(launch.launchpadId.id)
    }

    private fun getRocket(rocketId: String) {
        viewModelScope.launch {
            val response = repository.getRocketDetails(rocketId)

            if (response.isSuccessful) {
                val details = response.body() as RocketDetails
                selectedRocketDetails.postValue(details)
            } else {
                onError("Error: ${response.message()}")
            }
        }
    }

    private fun getLaunchpad(launchpadId: String) {
        viewModelScope.launch {
            val response = repository.getLaunchpadDetails(launchpadId)

            if (response.isSuccessful) {
                val details = response.body() as LaunchpadDetails
                selectedLaunchpadDetails.postValue(details)
            } else {
                onError("Error: ${response.message()}")
            }
        }
    }

    private fun onError(msgError: String) {
        errorMessage.value = msgError
    }
}