package com.devpass.spaceapp.presentation.launch.launchpad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.databinding.FragmentLaunchpadBinding

class LaunchpadFragment: Fragment() {

    private lateinit var txtTitle: TextView
    private lateinit var txtName: TextView
    private lateinit var txtLocal: TextView
    private lateinit var txtAttempts: TextView
    private lateinit var txtSuccesses: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLaunchpadBinding.inflate(inflater, container, false)

        txtTitle = binding.txtTitle
        txtName = binding.txtName
        txtLocal = binding.txtLocal
        txtAttempts = binding.txtAttempts
        txtSuccesses = binding.txtSuccesses

        return binding.root
    }
}