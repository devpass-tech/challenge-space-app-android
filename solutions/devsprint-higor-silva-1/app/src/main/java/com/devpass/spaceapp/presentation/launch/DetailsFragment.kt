package com.devpass.spaceapp.presentation.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.devpass.spaceapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var txtDetails: TextView

    private val args: DetailsFragmentArgs by navArgs()

    private val viewModel: LaunchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)

        txtDetails = binding.txtDetails
        txtDetails.text = args.textContent

        return binding.root
    }
}