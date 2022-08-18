package com.devpass.spaceapp.presentation.viewmodels

import androidx.lifecycle.*
import com.devpass.spaceapp.data.model.LaunchPageResponse
import com.devpass.spaceapp.data.model.OptionsRequest
import com.devpass.spaceapp.data.model.QueryParams
import com.devpass.spaceapp.data.webservice.InitializerApi
import com.devpass.spaceapp.infra.NetworkResult
import com.devpass.spaceapp.infra.isSuccess
import kotlinx.coroutines.launch

class NextLaunchesViewModel : ViewModel() {

    private val api by lazy { InitializerApi.getSpaceAPI() }

    private val _apiResult = MutableLiveData<NetworkResult<LaunchPageResponse>>()
    val apiResult: MutableLiveData<NetworkResult<LaunchPageResponse>> = _apiResult

    fun getNextLaunches() {
        viewModelScope.launch {
            val state: NetworkResult<LaunchPageResponse> = isSuccess {
                api.fetchNextLaunches(QueryParams(OptionsRequest(20)))
            }
            _apiResult.value = state
        }
    }
}