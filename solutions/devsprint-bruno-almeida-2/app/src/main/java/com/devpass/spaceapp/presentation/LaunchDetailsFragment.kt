package com.devpass.spaceapp.presentation

import LaunchDetailsPagerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.LaunchpadModel
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.RocketModel

private const val ARG_LAUNCH = "launch"
private const val ARG_ROCKET = "rocket"
private const val ARG_LAUNCHPAD = "launchpad"

class LaunchDetailsFragment : Fragment() {

    private lateinit var launch: NextLaunchesModel
    private lateinit var rocket: RocketModel
    private lateinit var launchpadModel: LaunchpadModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            launch = it.getSerializable(ARG_LAUNCH) as NextLaunchesModel
            rocket = it.getSerializable(ARG_ROCKET) as RocketModel
            launchpadModel = it.getSerializable(ARG_LAUNCHPAD) as LaunchpadModel
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
        val adapter = LaunchDetailsPagerAdapter(requireActivity(), launch, rocket,launchpadModel)
        viewPager.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(launch: NextLaunchesModel) =
            LaunchDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LAUNCH, launch)
                }
            }
    }
}

