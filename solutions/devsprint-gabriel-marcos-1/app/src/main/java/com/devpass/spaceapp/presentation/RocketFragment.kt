package com.devpass.spaceapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.devpass.spaceapp.databinding.FragmentRocketBinding

class RocketFragment : Fragment() {

    private lateinit var binding: FragmentRocketBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentRocketBinding.inflate(inflater, container, false)

        configureClickable()
        setup()

        return  binding.root
    }

    private fun configureClickable() {
        binding.cardViewRocket.setOnClickListener {
            val intent = Intent(context, RocketDetailsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setup() {

        binding.apply {
            Glide
                .with(this@RocketFragment)
                .load("https://farm5.staticflickr.com/4455/26280153979_b8016a829f_o.jpg")
                .centerCrop()
                .into(rocketImage)
            rocketName.text = "Falcon Heavy"
            rocketDescription.text =
                "With the ability to lift into orbit over 54 metric tons (119,000 lb)--a mass equivalent to a 737 jetliner loaded with passengers, crew, luggage and fuel--Falcon Heavy can lift more than twice the payload of the next closest operational vehicle, the Delta IV Heavy, at one-third the cost."
        }
    }
}