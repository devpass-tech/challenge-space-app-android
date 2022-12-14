package com.devpass.spaceapp.presentation.launch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.models.RocketDetails
import com.devpass.spaceapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val selectedRocketDetails = MutableLiveData<RocketDetails>()

    fun getRocket(rocketId: String) {
        viewModelScope.launch {

            val response = repository.getRocketDetails(rocketId)

            if (response.isSuccessful) {
                selectedRocketDetails.postValue(response.body())
            } else {
                onError("Error: ${response.message()}")
            }
        }
    }

    private fun onError(msgError: String){
        errorMessage.value = msgError
    }
}