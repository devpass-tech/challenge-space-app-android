package com.devpass.spaceapp.presentation.nextlaunches

import androidx.lifecycle.ViewModel
import com.devpass.spaceapp.data.api.SpaceXAPIClient
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.OptionsRequest
import com.devpass.spaceapp.data.model.QueryParams
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NextLaunchesViewModel(
    private val spaceXAPIClient: SpaceXAPIClient
): ViewModel() {

    private suspend fun getNextLaunches() {
        spaceXAPIClient.fetchNextLaunches(QueryParams(OptionsRequest(limit = 20))).docs
        (object : Callback<List<NextLaunchesModel>> {
            override fun onResponse(
                call: Call<List<NextLaunchesModel>>,
                response: Response<List<NextLaunchesModel>>
            ) {
                val launchList = response.body() ?: listOf()
            }

            override fun onFailure(
                call: Call<List<NextLaunchesModel>>,
                t: Throwable) {
            }
        })
    }
}