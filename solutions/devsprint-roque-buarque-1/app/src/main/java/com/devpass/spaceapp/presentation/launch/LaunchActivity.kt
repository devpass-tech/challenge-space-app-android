package com.devpass.spaceapp.presentation.launch

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.devpass.spaceapp.application.SpaceApp
import kotlinx.coroutines.launch
import javax.inject.Inject

class LaunchActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: LaunchActivityViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as SpaceApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        prepareObservers()
        viewModel.onEvent(LaunchActivityViewModel.LaunchEvents.Fetch)
    }

    private fun prepareObservers() {
        lifecycleScope.launch {
            viewModel.state.collect {
                when (it) {
                    LaunchActivityViewModel.LaunchState.Empty -> TODO()
                    is LaunchActivityViewModel.LaunchState.Error -> TODO()
                    LaunchActivityViewModel.LaunchState.Loading -> TODO()
                    is LaunchActivityViewModel.LaunchState.Success -> TODO()
                }
            }
        }
    }
}