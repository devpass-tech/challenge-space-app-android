package com.devpass.spaceapp.presentation.launch

import androidx.lifecycle.ViewModel
import com.devpass.spaceapp.data.repository.launch.LaunchRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class LaunchActivityViewModel @Inject constructor(
    private val launchRepository: LaunchRepository
) : ViewModel() {

    suspend fun onEvent(event: LaunchEvents) {
        this.event.emit(event)
    }

    private val event = MutableSharedFlow<LaunchEvents>()
    val state: Flow<LaunchState> = event
        .map {
            when (it) {
                LaunchEvents.Fetch -> getDataFromRepository()
            }
        }
        .onEach { LaunchState.Loading }

    private suspend fun getDataFromRepository(): LaunchState {
        val list = launchRepository.getData()
        return if (list.isEmpty()) {
            LaunchState.Empty
        } else {
            LaunchState.Success(list)
        }
    }

    sealed class LaunchEvents {
        object Fetch : LaunchEvents()
    }

    sealed class LaunchState {
        object Loading : LaunchState()
        data class Success(val list: List<String>) : LaunchState()
        object Empty : LaunchState()
        data class Error(val error: String) : LaunchState()
    }
}