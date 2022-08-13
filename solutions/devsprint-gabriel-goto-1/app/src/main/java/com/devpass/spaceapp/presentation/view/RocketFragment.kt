package com.devpass.spaceapp.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devpass.spaceapp.databinding.FragmentRocketBinding

class RocketFragment : Fragment() {

    private var _binding: FragmentRocketBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRocketBinding.inflate(inflater, container, false)
        setUpView()

        return binding.root
    }

    private fun setUpView() {
        binding.imageViewRocketFragment
        binding.textViewRocketFragmentTitle.text = ""
        binding.textViewRocketFragmentInfo.text = ""
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}