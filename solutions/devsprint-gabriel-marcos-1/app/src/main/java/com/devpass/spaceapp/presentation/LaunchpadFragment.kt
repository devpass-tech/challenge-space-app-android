package com.devpass.spaceapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentLaunchpadBinding

class LaunchpadFragment : Fragment(R.layout.fragment_launchpad) {

    private lateinit var binding: FragmentLaunchpadBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaunchpadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        binding.apply {
            name.text = "VAFB SLC 4E"
            locality.text = "Vandenberg Air Force Base"
            region.text = "California"
            viewMore.setOnClickListener {
                Toast.makeText(requireContext(), "Abrir próxima tela", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}