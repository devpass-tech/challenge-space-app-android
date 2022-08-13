package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding

class RocketDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRocketDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketDetailsBinding.inflate(layoutInflater)

        setUpView()
        setUpListeners()

        setContentView(binding.root)
    }

    fun setUpView() {
        binding.imageViewRocketActivity
        binding.textViewRocketActivityTitle.text = ""
        binding.textViewRocketActivityInfo.text = ""
    }

    fun setUpListeners() {
        binding.toolbarRocketActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}