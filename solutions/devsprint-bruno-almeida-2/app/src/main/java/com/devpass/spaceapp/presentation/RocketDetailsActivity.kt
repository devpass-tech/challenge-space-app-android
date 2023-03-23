package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding

class RocketDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRocketDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}


