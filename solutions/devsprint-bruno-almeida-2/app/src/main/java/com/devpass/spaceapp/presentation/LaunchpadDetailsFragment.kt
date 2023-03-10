package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.LaunchpadModel
import com.devpass.spaceapp.data.model.RocketModel

private const val ARG_LAUNCHPAD = "launchpad"

class LaunchpadDetailsFragment : Fragment() {

    private lateinit var launchpadModel: LaunchpadModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            launchpadModel = it.getSerializable(ARG_LAUNCHPAD) as LaunchpadModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_launchpad_details, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(launchpadModel: LaunchpadModel) =
            LaunchpadDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LAUNCHPAD, launchpadModel)
                }
            }
    }
}