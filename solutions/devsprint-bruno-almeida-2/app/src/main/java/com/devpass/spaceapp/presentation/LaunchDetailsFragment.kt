package com.devpass.spaceapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.FragmentLaunchDetailsBinding


private const val ARG_LAUNCH = "nextLaunch"

class LaunchDetailsFragment : Fragment() {

    private var _binding: FragmentLaunchDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLaunchDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupera o objeto NextLaunchesModel dos argumentos
        val launch = arguments?.getSerializable(ARG_LAUNCH) as NextLaunchesModel?

        // Exibe o nome da missão em um TextView
        binding.launchDescription.text = launch?.name ?: "Nome da missão desconhecido"
    }

    companion object {
        fun newInstance(launch: NextLaunchesModel) = LaunchDetailsFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ARG_LAUNCH, launch)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



//private const val ARG_LAUNCH = "launch"

/*
class LaunchDetailsFragment : Fragment() {

    private lateinit var launch: NextLaunchesModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            launch = it.getSerializable(ARG_LAUNCH) as NextLaunchesModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launch_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar o ViewPager2 com o LaunchDetailsPagerAdapter
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val adapter = LaunchDetailsPagerAdapter(requireActivity(), launch)
        viewPager.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LaunchDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LAUNCH, launch)
                }
            }
    }
}

*/
