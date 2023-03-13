package com.devpass.spaceapp.presentation.nextlaunches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.RetrofitService
import com.devpass.spaceapp.data.model.LaunchesResponse
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.OptionsRequest
import com.devpass.spaceapp.data.model.QueryParams
import com.devpass.spaceapp.data.repository.LaunchesListRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NextLaunchesViewModel(
    private val repository: LaunchesListRepositoryImpl
): ViewModel() {

    private var _launchList = MutableLiveData<List<NextLaunchesModel>>()
    //val launchList: LiveData<List<NextLaunchesModel>> = _launchList

    suspend fun getNextLaunches() {
        /*viewModelScope.launch{
            val launcherList =
                RetrofitService.retrofit(repository.fetchNextLaunches(QueryParams(
                OptionsRequest(20))
            ))
        }*/
        /*viewModelspaceXAPIClient.fetchNextLaunches(QueryParams(OptionsRequest(limit = 20))).docs
        (object : Callback<List<NextLaunchesModel>> {
            override fun onResponse(
                call: Call<List<NextLaunchesModel>>,
                response: Response<List<NextLaunchesModel>>
            ) {
                _launchList.value = response.body() ?: listOf()
            }

            override fun onFailure(
                call: Call<List<NextLaunchesModel>>,
                t: Throwable) {
            }
        })*/
        repository.fetchNextLaunches(params = QueryParams(OptionsRequest(20))).docs(
            object  : Callback<List<NextLaunchesModel>>{
                override fun onFailure(call: Call<List<NextLaunchesModel>>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<List<NextLaunchesModel>>,
                    response: Response<List<NextLaunchesModel>>
                ) {
                    _launchList.value = response.body() ?: listOf()
                }
            }
        )
    }
}