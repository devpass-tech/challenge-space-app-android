package com.devpass.spaceapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment(
    private val details: String
) : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: SpaceAppViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        configureClickable()
        setup()
        return binding.root
    }

    private fun configureClickable() {
        binding.textViewMore.setOnClickListener {
            val intent = Intent(context, LaunchDetailsActivity::class.java)
            intent.putExtra(LAUNCH_DETAILS_KEY, details)
            startActivity(intent)
        }
    }

    private fun setup() {
        binding.textDetails.text = details
    }

}
