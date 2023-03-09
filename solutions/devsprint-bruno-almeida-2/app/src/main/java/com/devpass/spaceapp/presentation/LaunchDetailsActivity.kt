package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.devpass.spaceapp.databinding.ActivityLaunchDetailsBinding

class LaunchDetailsActivity : AppCompatActivity() {

    private var launchCost: Int = 0
    private var rocketImageUrl: String? = null
    private var rocketName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLaunchDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar os dados do Bundle
        val launchCost = intent.getIntExtra("launchCost", 0)
        val launchImageUrl = intent.getStringExtra("launchImageUrl")
        val launchName = intent.getStringExtra("launchName")

        // Usar os dados para preencher o layout
        binding.launchNumber.text = launchCost.toString()
        Glide.with(this)
            .load(launchImageUrl)
            .into(binding.launchImage)
        binding.launchTitle.text = launchName
    }
}