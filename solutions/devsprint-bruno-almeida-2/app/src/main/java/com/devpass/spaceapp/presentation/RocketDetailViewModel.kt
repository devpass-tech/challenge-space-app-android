package com.devpass.spaceapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devpass.spaceapp.data.model.RocketDetailResponse
import com.devpass.spaceapp.data.repository.RocketDetailsRepository

import androidx.lifecycle.LiveData

import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

class RocketDetailsViewModel(private val repository: RocketDetailsRepository, private val id: String) : ViewModel() {

    private val _rocketDetail = MutableLiveData<Result<RocketDetailResponse>>()
    val rocketDetail: LiveData<Result<RocketDetailResponse>>
        get() = _rocketDetail

    init {
        viewModelScope.launch {
            _rocketDetail.value = repository.getRocketDetails(id)
        }
    }
}


