package com.devpass.spaceapp.presentation.rocket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding

class RocketDetailsActivity : AppCompatActivity() {
    private val rocketDetailsActivityBinding by viewBinding(ActivityRocketDetailsBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(rocketDetailsActivityBinding.root)
    }
}