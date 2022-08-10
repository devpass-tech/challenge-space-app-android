package com.devpass.spaceapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.LaunchDetailsFragmentBinding

class LaunchDetailsFragment : Fragment(R.layout.launch_details_fragment) {

    private var bind: LaunchDetailsFragmentBinding? = null
    private val binding get() = bind

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = LaunchDetailsFragmentBinding.inflate(inflater, container, false)
        setView()

        return binding.root
    }

    private fun setView() {
        binding.descriptionText.text = getString(R.string.launch_details_dummy_text)
        binding.viewMoreButton.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Chamar LaunchDetailsActivity aqui",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}