package com.devpass.spaceapp.presentation

import android.content.Intent
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

        val fullDescription = launch?.details ?: "Erro ao carregar detalhes"

        // Exibe as 3 primeiras linhas de details em um TextView
        val shortDescription = fullDescription.lineSequence().take(1).joinToString("\n")
        binding.launchDescriptionFragment.text = shortDescription

        val viewMore = "View more..."

        val viewMoreLink = binding.launchViewMore

        viewMoreLink.text = viewMore

        viewMoreLink.setOnClickListener {
            val intent = Intent(context, LaunchDetailsActivity::class.java)
            intent.putExtra("fullLaunchDescription", fullDescription)
            startActivity(intent)
        }
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
