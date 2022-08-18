package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityMainBinding
import com.devpass.spaceapp.infra.NetworkResult
import com.devpass.spaceapp.presentation.adapters.NextLaunchesAdapter
import com.devpass.spaceapp.presentation.viewmodels.NextLaunchesViewModel
import com.google.android.material.snackbar.Snackbar

class NextLaunchesActivity : AppCompatActivity() {

    private val viewModel = NextLaunchesViewModel()
    private lateinit var adapter: NextLaunchesAdapter

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val snackBarError by lazy {
        Snackbar.make(binding.root, R.string.snackbar_error, Snackbar.LENGTH_INDEFINITE).apply {
            setAction(R.string.retry) { loadItems() }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        loadItems()
    }

    private fun loadItems() {
        viewModel.getNextLaunches()
        viewModel.apiResult.observe(this) {
            when (it) {
                is NetworkResult.Loading -> {
                    binding.loading.visibility = View.VISIBLE
                }

                is NetworkResult.Success -> {
                    binding.loading.visibility = View.GONE
                    it.data?.let { it1 -> adapter.addList(it1) }
                }

                is NetworkResult.Error -> {
                    binding.loading.visibility = View.GONE
                    snackBarError

                }
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = NextLaunchesAdapter()
        binding.nextLaunchesRecyclerview.layoutManager =
            LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        binding.nextLaunchesRecyclerview.adapter = adapter
    }
}