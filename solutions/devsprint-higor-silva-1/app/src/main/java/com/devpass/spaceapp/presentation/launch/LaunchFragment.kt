package com.devpass.spaceapp.presentation.launch

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.devpass.spaceapp.*
import com.devpass.spaceapp.databinding.FragmentLaunchBinding
import com.devpass.spaceapp.models.*
import com.devpass.spaceapp.presentation.adapter.TabsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll

@AndroidEntryPoint
class LaunchFragment : Fragment() {

    private val viewModel: LaunchViewModel by viewModels()

    private val args: LaunchFragmentArgs by navArgs()

    private lateinit var imgFolder: ImageView
    private lateinit var txtTitle: TextView
    private lateinit var txtDate: TextView
    private lateinit var txtStatus: TextView
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var launch: Launch

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().title = ""

        val binding = FragmentLaunchBinding.inflate(inflater, container, false)

        launch = args.selectedLaunch

        viewModel.getRocket(launch.rocketLaunch.rocket_id)
        viewModel.getLaunchpad(launch.launchpadId.id)

        imgFolder = binding.img
        txtTitle = binding.txtTitle
        txtDate = binding.txtDate
        txtStatus = binding.txtStatus
        tabLayout = binding.tabLayout
        viewPager = binding.viewPager

        setLaunchProperties(launch)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedRocketDetails.observe(viewLifecycleOwner) {
            launch = launch.setRocket(it)
            viewModel.setIsFinishGetRocket(true)
        }

        viewModel.selectedLaunchpadDetails.observe(viewLifecycleOwner) {
            launch = launch.setLaunchpad(it)
            viewModel.setIsFinishGetLaunchpad(true)
        }

        viewModel.isFinish.observe(viewLifecycleOwner){
            if(it){
                fillTabLayout(launch)
            }
        }
    }

    private fun setLaunchProperties(launch: Launch) {

        imgFolder.load(launch.getImgLink())
        txtTitle.text = launch.title
        txtDate.text = launch.formatDate()
        txtStatus.text = launch.getStatus(requireContext())
    }

    private fun fillTabLayout(launch: Launch) {

        val tabAdapter = TabsPagerAdapter(requireContext(), requireActivity(), launch)

        viewPager.apply {
            adapter = tabAdapter
            currentItem = 0
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = tabAdapter.getTabTitle(pos)
        }.attach()
    }
}




