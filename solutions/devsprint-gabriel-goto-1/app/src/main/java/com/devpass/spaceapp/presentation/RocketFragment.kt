package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devpass.spaceapp.databinding.FragmentRocketBinding

class RocketFragment : Fragment() {

    private var bind: FragmentRocketBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bind = FragmentRocketBinding.inflate(inflater, container, false)
        setUpView()

        return binding.root
    }

    private fun setUpView() {
        binding.imageViewRocketFragment
        binding.textViewRocketFragmentTitle.text = ""
        binding.textViewRocketFragmentInfo.text = ""
    }
}