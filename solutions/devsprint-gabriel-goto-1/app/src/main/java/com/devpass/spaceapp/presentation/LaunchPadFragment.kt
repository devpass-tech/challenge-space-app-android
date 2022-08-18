package com.devpass.spaceapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.devpass.spaceapp.databinding.FragmentLaunchPadBinding
import com.devpass.spaceapp.presentation.viewmodels.NextLaunchesViewModel

class LaunchPadFragment : Fragment() {

    private val viewModel by activityViewModels<NextLaunchesViewModel>()

    private var bind: FragmentLaunchPadBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentLaunchPadBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        binding.textViewRocketName.text = ""
        binding.textViewBase.text = ""
        binding.textViewCountry.text = ""
        binding.buttonViewMore.setOnClickListener {
            //TODO - fazer a navegacao para a prox view
        }
    }

    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }
}