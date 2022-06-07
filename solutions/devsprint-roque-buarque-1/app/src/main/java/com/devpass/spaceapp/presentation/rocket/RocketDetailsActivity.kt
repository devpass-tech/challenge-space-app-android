package com.devpass.spaceapp.presentation.rocket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding
import com.devpass.spaceapp.presentation.utils.viewBinding

class RocketDetailsActivity : AppCompatActivity() {
    private val rocketDetailsActivityBinding by viewBinding(ActivityRocketDetailsBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(rocketDetailsActivityBinding.root)
    }
}