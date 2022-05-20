package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding

class RocketDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRocketDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val drawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back)
        supportActionBar?.setHomeAsUpIndicator(drawable)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setup()
    }

    private fun setup() {
        binding.apply {
            name.text = "Falcon Heavy"
            details.text =
                "With the ability to lift into orbit over 54 metric tons (119,000 lb)--a mass equivalent to a 737 jetliner loaded with passengers, crew, luggage and fuel--Falcon Heavy can lift more than twice the payload of the next closest operational vehicle, the Delta IV Heavy, at one-third the cost."
        }
    }

}