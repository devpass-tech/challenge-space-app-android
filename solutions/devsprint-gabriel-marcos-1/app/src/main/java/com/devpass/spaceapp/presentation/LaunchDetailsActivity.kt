package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.LaunchDetailsActivityBinding

const val LAUNCH_DETAILS_KEY = "launchDetailsKey"

class LaunchDetailsActivity : AppCompatActivity() {

    private lateinit var binding: LaunchDetailsActivityBinding

    private val details: String? by lazy {
        intent.getStringExtra(LAUNCH_DETAILS_KEY)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LaunchDetailsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.tab_title_one)

        binding.detailsText.text = details
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}