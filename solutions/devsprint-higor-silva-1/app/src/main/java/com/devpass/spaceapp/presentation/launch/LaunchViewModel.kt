package com.devpass.spaceapp.presentation.launch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.models.Rocket
import com.devpass.spaceapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val selectedRocket = MutableLiveData<Rocket>()

    fun getRocket(rocketId: String) {
        viewModelScope.launch {

            val response = repository.getRocket(rocketId)

            if(response.isSuccessful){
                selectedRocket.postValue(response.body())
            } else {
                onError("Error: ${response.message()}")
            }
        }
    }

    private fun onError(msgError: String){
        errorMessage.value = msgError
    }
}