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

    private fun setUpView() {
        val title = intent.getStringExtra("EXTRA_TITLE")
        val info = intent.getStringExtra("EXTRA_INFO")
        binding.imageViewRocketActivity
        binding.textViewRocketActivityTitle.text = title
        binding.textViewRocketActivityInfo.text = info
    }

    private fun setUpListeners() {
        binding.toolbarRocketActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}