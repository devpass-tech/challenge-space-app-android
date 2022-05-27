package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.devpass.spaceapp.data.model.RocketModel
import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding

class RocketDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRocketDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        intent.extras?.get("rocketDetails").let {
            if (it is RocketModel) {
                setup(it)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setup(rocketDetails: RocketModel) {
        title = rocketDetails.name
        binding.apply {
            name.text = rocketDetails.name
            details.text = rocketDetails.description
            Glide.with(this@RocketDetailsActivity).load(rocketDetails.image.first()).into(image)
        }
    }
}