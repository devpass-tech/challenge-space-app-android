package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class NextLaunchesActivity : AppCompatActivity() {

    private val viewModel = NextLaunchesViewModel()

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
        //TODO
    }

    private fun setupRecyclerView() {
        binding.nextLaunchesRecyclerview.layoutManager =
            LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
    }
}