package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityLaunchPadDetailsBinding

class LaunchpadDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchPadDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchPadDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val drawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back)
        supportActionBar?.setHomeAsUpIndicator(drawable)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setup()
    }

    private fun setup() {
        binding.apply {
            name.text = "VAFB SLC 4E"
            locality.text = "Vandenberg Air Force Base"
            region.text = "California"
            launchAttempts.text = "Launch Attempts: 15"
            launchSuccesses.text = "Launch Successes: 15"
        }
    }

}