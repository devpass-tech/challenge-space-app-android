package com.devpass.spaceapp.presentation.nextlaunches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.OptionsRequest
import com.devpass.spaceapp.data.model.QueryParams
import com.devpass.spaceapp.data.repository.LaunchesListRepositoryImpl
import kotlinx.coroutines.launch

class NextLaunchesViewModel(
    private val repository: LaunchesListRepositoryImpl
): ViewModel() {

    private var _launchList = MutableLiveData<List<NextLaunchesModel>>()
    val launchList: LiveData<List<NextLaunchesModel>> = _launchList

    private var _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun getNextLaunches(limit: Int = 20) {
        viewModelScope.launch {
            val nextLaunches = repository.fetchNextLaunches(QueryParams(OptionsRequest(limit)))
            nextLaunches
                .onSuccess {
                    _launchList.postValue(it)
                }
                .onFailure {
                    _error.postValue(it)
                }

        }
    }
}