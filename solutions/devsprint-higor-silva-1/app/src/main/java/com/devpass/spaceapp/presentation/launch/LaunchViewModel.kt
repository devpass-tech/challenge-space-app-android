package com.devpass.spaceapp.presentation.launch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.models.LaunchpadDetails
import com.devpass.spaceapp.models.RocketDetails
import com.devpass.spaceapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()

    var isFinish = MutableLiveData<Boolean>()
    var isFinishGetRocket = false
    var isFinishGetLaunchpad = false

    val selectedRocketDetails = MutableLiveData<RocketDetails>()
    val selectedLaunchpadDetails = MutableLiveData<LaunchpadDetails>()

    fun getRocket(rocketId: String) {
        isFinishGetRocket = false

        viewModelScope.launch {
            val response = repository.getRocketDetails(rocketId)

            if (response.isSuccessful) {
                selectedRocketDetails.postValue(response.body())

            } else {
                onError("Error: ${response.message()}")
            }
        }
    }

    fun getLaunchpad(launchpadId: String){
        isFinishGetLaunchpad = false

        viewModelScope.launch {
            val response = repository.getLaunchpadDetails(launchpadId)

            if(response.isSuccessful){
                selectedLaunchpadDetails.postValue(response.body())

            } else {
                onError("Error: ${response.message()}")
            }
        }
    }

    fun setIsFinishGetLaunchpad(finish: Boolean){
        isFinishGetLaunchpad = true
        isFinish.value = isFinishGetRocket && isFinishGetLaunchpad
    }

    fun setIsFinishGetRocket(finish: Boolean){
        isFinishGetRocket = true
        isFinish.value = isFinishGetRocket && isFinishGetLaunchpad
    }

    private fun onError(msgError: String){
        errorMessage.value = msgError
    }
}