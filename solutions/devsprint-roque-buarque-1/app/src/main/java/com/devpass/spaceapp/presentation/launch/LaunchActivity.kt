package com.devpass.spaceapp.presentation.launch

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.devpass.spaceapp.application.SpaceApp
import com.devpass.spaceapp.databinding.ActivityNextLaunchesBinding
import com.devpass.spaceapp.presentation.utils.viewBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class LaunchActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityNextLaunchesBinding::inflate)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: LaunchActivityViewModel by viewModels {
        viewModelFactory
    }

    override fun onStart() {
        super.onStart()
        prepareObservers()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as SpaceApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        prepareObservers()
        viewModel.onEvent(LaunchActivityViewModel.LaunchEvents.Fetch)
    }

    private fun prepareObservers() {
        lifecycleScope.launch {
            viewModel.state.collect {
                when (it) {
                    LaunchActivityViewModel.LaunchState.Empty -> {
                        binding.rvNextLaunches.isVisible = false
                        binding.loading.isVisible = false
                        binding.tvMessage.isVisible = true
                        binding.tvMessage.text = "Lista Vazia"
                    }
                    is LaunchActivityViewModel.LaunchState.Error -> {
                        binding.rvNextLaunches.isVisible = false
                        binding.loading.isVisible = true
                        binding.tvMessage.isVisible = true
                        binding.tvMessage.text = it.error
                    }
                    LaunchActivityViewModel.LaunchState.Loading -> {
                        binding.rvNextLaunches.isVisible = false
                        binding.loading.isVisible = true
                        binding.tvMessage.isVisible = false
                    }
                    is LaunchActivityViewModel.LaunchState.Success -> {
                        binding.rvNextLaunches.isVisible = true
                        binding.loading.isVisible = false
                        binding.tvMessage.isVisible = false
                        binding.rvNextLaunches.adapter= LaunchAdapter(it.list)
                    }
                }
            }
        }
    }
}