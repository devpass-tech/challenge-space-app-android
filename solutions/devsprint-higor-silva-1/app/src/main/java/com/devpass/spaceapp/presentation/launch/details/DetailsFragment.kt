package com.devpass.spaceapp.presentation.launch.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var txtDetails: TextView

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)

        requireActivity().title = getString(R.string.title_fragment_details)

        txtDetails = binding.txtDetails
        txtDetails.text = args.textContent

        return binding.root
    }
}