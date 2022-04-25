package com.devpass.spaceapp.presentation.launchCellView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.presentation.States
import com.devpass.spaceapp.repository.FetchLaunchesRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val fetchLaunchesRepositoryImpl: FetchLaunchesRepositoryImpl
) : ViewModel() {
    private val _state = MutableLiveData<States>()
    val state: LiveData<States> = _state

    fun executeFetchLaunches() {
        viewModelScope.launch {
            fetchLaunchesRepositoryImpl.fetchNextLaunches()
                .flowOn(Dispatchers.IO)
                .onStart { _state.value = States.Loading }
                .catch { _state.value = States.Failure(it.message) }
                .collect { _state.value = States.Success(it) }
        }
    }
}