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

class DetailsFragment : Fragment() {

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
            startActivity(intent)
        }
    }

    private fun setup() {
        viewModel.getRocketDetails("5e9d0d95eda69974db09d1ed")
        viewModel.resultRocketDetails.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.textDetails.text = it.description
            } else {
                binding.textDetails.text = getString(R.string.rocket_details_fail)
            }
        }
    }

}
