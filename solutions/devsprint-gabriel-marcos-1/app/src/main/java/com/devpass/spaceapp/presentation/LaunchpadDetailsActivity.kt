package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.databinding.ActivityLaunchPadDetailsBinding

class LaunchpadDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchPadDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchPadDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onStart() {
        super.onStart()
        setup()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setup() {

        title = "VAFB SLC 4E"

        binding.apply {
            name.text = "VAFB SLC 4E"
            locality.text = "Vandenberg Air Force Base"
            region.text = "California"
            launchAttempts.text = "Launch Attempts: 15"
            launchSuccesses.text = "Launch Successes: 15"
        }
    }
}