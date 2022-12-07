package com.devpass.spaceapp.presentation.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var txtDetails: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)

        txtDetails = binding.txtDetails
        txtDetails.text = arguments?.getString(EXTRA_DETAILS)

        return binding.root
    }

    companion object {
        const val TAG_DETAIS = "tagDetails"
        private const val EXTRA_DETAILS = "details"

        fun newInstance(detais: String) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putString(EXTRA_DETAILS, detais)
            }
        }
    }
}