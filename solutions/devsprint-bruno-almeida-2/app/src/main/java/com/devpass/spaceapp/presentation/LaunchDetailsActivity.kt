package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.ActivityLaunchDetailsBinding

private const val ARG_LAUNCH = "fullLaunchDescription"

class LaunchDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLaunchDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar o objeto launch da intent
        val launch = intent.getSerializableExtra(ARG_LAUNCH) as NextLaunchesModel

        // Preencher os campos com as informações do objeto launch
        binding.launchDescriptionTextView.text = launch.details
    }
}