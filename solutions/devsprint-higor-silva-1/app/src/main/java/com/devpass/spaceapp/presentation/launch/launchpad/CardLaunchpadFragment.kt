package com.devpass.spaceapp.presentation.launch.launchpad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devpass.spaceapp.databinding.FragmentCardLaunchpadBinding
import com.devpass.spaceapp.presentation.launch.LaunchFragmentDirections

class CardLaunchpadFragment : Fragment() {

    private val args: CardLaunchpadFragmentArgs by navArgs()

    private lateinit var txtTitle: TextView
    private lateinit var txtName: TextView
    private lateinit var txtLocal: TextView
    private lateinit var btnViewMore: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCardLaunchpadBinding.inflate(inflater, container, false)

        txtTitle = binding.txtTitle
        txtName = binding.txtName
        txtLocal = binding.txtLocal
        btnViewMore = binding.btnViewMore

        txtTitle.text = args.selectedLaunchpad.name
        txtName.text = args.selectedLaunchpad.siteName
        txtLocal.text = args.selectedLaunchpad.location.nameLocation

        btnViewMore.setOnClickListener {
            val action =
                LaunchFragmentDirections
                    .actionLaunchFragmentToLaunchpadFragment(args.selectedLaunchpad)

            findNavController().navigate(action)
        }

        return binding.root
    }

}