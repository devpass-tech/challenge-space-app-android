package com.devpass.spaceapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.databinding.FragmentLaunchListBinding

class LaunchListFragment : Fragment() {

    private lateinit var binding: FragmentLaunchListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaunchListBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }
}