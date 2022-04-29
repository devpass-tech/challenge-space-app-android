package com.devpass.spaceapp.presentation.launchCellView

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityLaunchCellViewBinding
import com.devpass.spaceapp.presentation.LaunchStates
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchCellView : AppCompatActivity() {
    private lateinit var binding: ActivityLaunchCellViewBinding

    private lateinit var adapter: LaunchAdapter
    private val viewModel by viewModels<LaunchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchCellViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycleView()
        initListLaunches()
    }

    private fun initListLaunches() {
        viewModel.executeFetchLaunches()
        viewModel.state.observe(this){state ->
            when(state){
                LaunchStates.Loading -> binding.pbLaunches.visibility = View.VISIBLE

                is LaunchStates.Failure -> {
                    binding.pbLaunches.visibility = View.GONE
                    Toast.makeText(this, R.string.label_msg_error, Toast.LENGTH_SHORT).show()
                }

                is LaunchStates.Success -> {
                    binding.pbLaunches.visibility = View.GONE
                    adapter.submitList(state.launches.docs)
                }
            }
        }
    }


    private fun setupRecycleView() {
        adapter = LaunchAdapter()
        binding.rvLaunches.adapter = adapter
        binding.rvLaunches.layoutManager = LinearLayoutManager(this)
    }
}