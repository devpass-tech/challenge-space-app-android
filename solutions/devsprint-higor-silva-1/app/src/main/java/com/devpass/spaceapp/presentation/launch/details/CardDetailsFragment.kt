package com.devpass.spaceapp.presentation.launch.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentCardDetailsBinding
import com.devpass.spaceapp.presentation.launch.LaunchFragmentDirections

class CardDetailsFragment : Fragment() {

    private val args: CardDetailsFragmentArgs by navArgs()

    private lateinit var txtCardDetails: TextView
    private lateinit var btnViewMore: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCardDetailsBinding.inflate(inflater, container, false)

        val textDetails =
            args.selectedLaunch.details ?: requireActivity().resources.getString(R.string.uknown)
        txtCardDetails = binding.txtCardDetails
        btnViewMore = binding.btnViewMore

        txtCardDetails.text = textDetails

        btnViewMore.setOnClickListener {
            val action = LaunchFragmentDirections.actionLaunchFragmentToDetailsFragment(textDetails)
            findNavController().navigate(action)
        }

        return binding.root
    }
}
