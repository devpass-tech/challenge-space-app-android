package com.devpass.spaceapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        configureClickable()

        return binding.root
    }

    private fun configureClickable() {
        binding.textViewMore.setOnClickListener {
            val intent = Intent(context, LaunchDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}