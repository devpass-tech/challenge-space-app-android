package com.devpass.spaceapp.presentation.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.data.model.NextLaunchesItem
import com.devpass.spaceapp.data.repository.launch.LaunchRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class LaunchActivityViewModel @Inject constructor(
    private val launchRepository: LaunchRepository
) : ViewModel() {

    private val event = MutableSharedFlow<LaunchEvents>()
    val state: Flow<LaunchState> = event
        .map {
            when (it) {
                LaunchEvents.Fetch -> getDataFromRepository()
            }
        }
        .onStart { emit(LaunchState.Loading) }
        .catch { LaunchState.Error("Something went wrong") }

    fun onEvent(event: LaunchEvents) {
        viewModelScope.launch {
            this@LaunchActivityViewModel.event.emit(event)
        }
    }

    private suspend fun getDataFromRepository(): LaunchState {
        val result = launchRepository.getNextLaunches()
        return if (result.isSuccess) {
            val list = result.getOrThrow().launches
            if (list.isEmpty()) {
                LaunchState.Empty
            } else {
                LaunchState.Success(list)
            }
        } else {
            LaunchState.Error("Something went wrong")
        }
    }

    sealed class LaunchEvents {
        object Fetch : LaunchEvents()
    }

    sealed class LaunchState {
        object Loading : LaunchState()
        data class Success(val list: List<NextLaunchesItem>) : LaunchState()
        object Empty : LaunchState()
        data class Error(val error: String) : LaunchState()
    }

}