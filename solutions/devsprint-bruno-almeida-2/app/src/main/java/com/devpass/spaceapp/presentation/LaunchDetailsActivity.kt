package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.ActivityLaunchDetailsBinding

class LaunchDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLaunchDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar o objeto launch da intent
        val launch = intent.getSerializableExtra("nextLaunch") as NextLaunchesModel

        // Preencher os campos com as informações do objeto launch
        binding.launchTitleTextView.text = launch.name
        binding.launchDateTextView.text = launch.date.toString()
        binding.launchStatusTextView.text = launch.status.toString()
        Glide.with(this).load(launch.image).into(binding.launchImage)
    }
}