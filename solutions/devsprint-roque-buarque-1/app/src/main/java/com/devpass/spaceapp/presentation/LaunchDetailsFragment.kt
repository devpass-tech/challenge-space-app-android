package com.devpass.spaceapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.databinding.FragmentLaunchDetailsBinding

class LaunchDetailsFragment : Fragment() {
    private var _binding: FragmentLaunchDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLaunchDetailsBinding.inflate(inflater, container, false)
        configVmClick()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configVmClick()
    }

    private fun configVmClick() {
        binding.buttonVm.setOnClickListener {
            val intent = Intent(context, LaunchDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}