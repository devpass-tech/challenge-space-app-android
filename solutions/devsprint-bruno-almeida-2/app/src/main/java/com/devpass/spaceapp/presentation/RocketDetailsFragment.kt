package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.RocketModel

private const val ARG_ROCKET = "rocket"

class RocketDetailsFragment : Fragment() {
    private lateinit var rocket: RocketModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            rocket = it.getSerializable(ARG_ROCKET) as RocketModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rocket_details, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(rocket: RocketModel) =
            RocketDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_ROCKET, rocket)
                }
            }
    }
}
