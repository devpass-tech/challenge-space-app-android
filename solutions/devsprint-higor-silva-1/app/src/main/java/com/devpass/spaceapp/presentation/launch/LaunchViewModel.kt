package com.devpass.spaceapp.presentation.launch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val selectedLaunch = MutableLiveData<Launch>()

    fun setSelectedLaunch(launch: Launch){
        selectedLaunch.postValue(launch)
    }
}