package com.devpass.spaceapp.presentation

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

    private val _apiResult = MutableLiveData<NetworkResult<LaunchPageResponse>>(NetworkResult.Loading())
    val apiResult: LiveData<NetworkResult<LaunchPageResponse>>
        get() = _apiResult

    fun getNextLaunches() {
        viewModelScope.launch {
            _apiResult.value = NetworkResult.Loading()
            val state: NetworkResult<LaunchPageResponse> = isSuccess {
                api.fetchNextLaunches(QueryParams(OptionsRequest(20)))
            }
            _apiResult.value = state
        }
    }
}