package com.devpass.spaceapp.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val launchList = MutableLiveData<List<Launch>>()
    val isLoading = MutableLiveData<Boolean>()

     fun getLaunchs() {
        isLoading.value = true

        viewModelScope.launch {
            val response = repository.getLaunches()

            if (response.isSuccessful) {
                launchList.postValue(response.body())
                isLoading.value = false
            } else {
                onError("Error: ${response.message()}")
            }
        }
    }

    private fun onError(msgError: String) {
        errorMessage.value = msgError
        isLoading.value = false
    }

}