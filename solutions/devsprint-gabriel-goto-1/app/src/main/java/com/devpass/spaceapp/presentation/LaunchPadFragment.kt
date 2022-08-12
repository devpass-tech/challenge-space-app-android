package com.devpass.spaceapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.databinding.FragmentLaunchPadBinding

class LaunchPadFragment : Fragment() {

    private var bind: FragmentLaunchPadBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bind = FragmentLaunchPadBinding.inflate(inflater, container, false)
        setUpView()

        return binding.root
    }

    private fun setUpView() {
        binding.textViewRocketName.text = ""
        binding.textViewBase.text = ""
        binding.textViewCountry.text = ""
        binding.textViewViewMore.setOnClickListener {
            //TODO - fazer a navegacao para a prox view
        }
    }
}