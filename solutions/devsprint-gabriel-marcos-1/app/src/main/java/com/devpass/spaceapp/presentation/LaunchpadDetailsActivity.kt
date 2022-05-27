package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.LaunchPadModel
import com.devpass.spaceapp.databinding.ActivityLaunchPadDetailsBinding

class LaunchpadDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchPadDetailsBinding
    private lateinit var launchPad: LaunchPadModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchPadDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getIntentExtra()
        dataSetup()
    }

    private fun getIntentExtra() {
        intent?.let {
            launchPad = it.getSerializableExtra("launchpad") as LaunchPadModel
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun dataSetup() {

        title = launchPad.name

        binding.apply {
            name.text = launchPad.name
            locality.text = launchPad.locality
            region.text = launchPad.region
            launchAttempts.text = "${getString(R.string.launch_attempts)} ${launchPad.launchAttempts}"
            launchSuccesses.text = "${getString(R.string.launch_success)} ${launchPad.launchSuccesses}"
        }
    }
}