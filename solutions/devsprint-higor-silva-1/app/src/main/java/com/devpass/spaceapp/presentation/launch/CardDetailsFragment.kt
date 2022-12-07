package com.devpass.spaceapp.presentation.launch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentCardDetailsBinding

class CardDetailsFragment : Fragment() {

    private lateinit var txtCardDetails: TextView
    private lateinit var btnViewMore: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCardDetailsBinding.inflate(inflater, container, false)

        txtCardDetails = binding.txtCardDetails
        btnViewMore = binding.btnViewMore

        txtCardDetails.text = resources.getString(R.string.txt_details_mock)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment = DetailsFragment.newInstance(txtCardDetails.text.toString())

        btnViewMore.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment, DetailsFragment.TAG_DETAIS)
                .setTransition(TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
    }
}
