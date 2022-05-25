package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityNextLaunchesBinding

class NextLaunchesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextLaunchesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextLaunchesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        title = getString(R.string.next_launches_title)

        val adapter = LaunchAdapterItem(listOf())
        binding.listNextLaunches.adapter = adapter
    }
}