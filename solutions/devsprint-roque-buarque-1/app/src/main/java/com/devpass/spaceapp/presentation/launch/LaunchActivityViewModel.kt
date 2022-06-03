package com.devpass.spaceapp.presentation.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.repository.launch.LaunchRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class LaunchActivityViewModel @Inject constructor(
    private val launchRepository: LaunchRepository
): ViewModel() {

    //Sample repository call with coroutines
    fun getDataFromRepository() {
        viewModelScope.launch {
            launchRepository.getData()
        }
    }
}