package com.devpass.spaceapp.presentation.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.devpass.spaceapp.databinding.FragmentRocketBinding

class RocketFragment: Fragment() {

    private val args: RocketFragmentArgs by navArgs()

    private lateinit var imgRocket: ImageView
    private lateinit var txtTitleRocket: TextView
    private lateinit var txtDetailsRocket: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRocketBinding.inflate(inflater, container, false)

        imgRocket = binding.imgRocket
        txtTitleRocket = binding.txtTitleRocket
        txtDetailsRocket = binding.txtDetailsRocket

        imgRocket.load(args.selectedRocket.images[0])
        txtTitleRocket.text = args.selectedRocket.rocketName
        txtDetailsRocket.text = args.selectedRocket.description

        return binding.root
    }
}