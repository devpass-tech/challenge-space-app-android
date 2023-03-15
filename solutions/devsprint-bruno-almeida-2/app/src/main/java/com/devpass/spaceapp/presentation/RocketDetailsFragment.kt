package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.FragmentRocketDetailsBinding

private const val ARG_LAUNCH = "rocket"

class RocketDetailsFragment : Fragment() {

    private var _binding: FragmentRocketDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRocketDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupera o objeto NextLaunchesModel dos argumentos
        val launch = arguments?.getSerializable(ARG_LAUNCH) as NextLaunchesModel?

        // Exibe o nome da missão em um TextView
        binding.rocketDescription.text = launch?.name ?: "Nome da missão desconhecido"
    }

    companion object {
        fun newInstance(launch: NextLaunchesModel) = RocketDetailsFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ARG_LAUNCH, launch)
            }
        }
    }
}
