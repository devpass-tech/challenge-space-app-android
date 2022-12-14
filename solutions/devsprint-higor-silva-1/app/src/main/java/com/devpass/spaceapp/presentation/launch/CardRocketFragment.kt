package com.devpass.spaceapp.presentation.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.devpass.spaceapp.databinding.FragmentCardRocketBinding

class CardRocketFragment : Fragment() {

    private val args: CardRocketFragmentArgs by navArgs()

    private lateinit var imgRocket: ImageView
    private lateinit var txtCardTitleRocket: TextView
    private lateinit var txtCardDetailsRocket: TextView
    private lateinit var btnViewMore: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCardRocketBinding.inflate(inflater, container, false)

        imgRocket = binding.imgRocket
        txtCardTitleRocket = binding.txtCardTitleRocket
        txtCardDetailsRocket = binding.txtCardDetailsRocket
        btnViewMore = binding.btnViewMore

        imgRocket.load(args.selectedRocket.images[0])
        txtCardTitleRocket.text = args.selectedRocket.rocketName
        txtCardDetailsRocket.text = args.selectedRocket.description

        btnViewMore.setOnClickListener {
            val action = LaunchFragmentDirections.actionLaunchFragmentToRocketFragment(args.selectedRocket)
            findNavController().navigate(action)
        }

        return binding.root
    }
}