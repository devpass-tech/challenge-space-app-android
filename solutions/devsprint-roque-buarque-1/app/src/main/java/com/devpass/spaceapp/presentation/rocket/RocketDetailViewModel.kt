package com.devpass.spaceapp.presentation.rocket

import androidx.lifecycle.ViewModel
import com.devpass.spaceapp.data.repository.rocket.RocketRepository
import javax.inject.Inject

class RocketDetailViewModel @Inject constructor(
    private val rocketRepository: RocketRepository
): ViewModel() {


}