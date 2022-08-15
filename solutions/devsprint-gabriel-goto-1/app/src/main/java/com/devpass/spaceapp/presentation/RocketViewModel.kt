package com.devpass.spaceapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.model.LaunchPageResponse
import com.devpass.spaceapp.data.model.OptionsRequest
import com.devpass.spaceapp.data.model.QueryParams
import com.devpass.spaceapp.data.webservice.InitializerApi
import com.devpass.spaceapp.infra.NetworkResult
import com.devpass.spaceapp.infra.isSuccess
import kotlinx.coroutines.launch

class NextLaunchesViewModel : ViewModel() {

    private val api by lazy { InitializerApi.getSpaceAPI() }

    fun getNextLaunches() {
        viewModelScope.launch {
            val state: NetworkResult<LaunchPageResponse> = isSuccess {
                api.fetchNextLaunches(QueryParams(OptionsRequest(20)))
            }
        }
    }
}