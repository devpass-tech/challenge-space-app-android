package com.devpass.spaceapp.presentation.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentLaunchBinding
import com.devpass.spaceapp.models.Rocket
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LaunchFragment : Fragment(){

    private lateinit var binding: FragmentLaunchBinding

    private lateinit var imgFolder: ImageView
    private lateinit var txtTitle: TextView
    private lateinit var txtDate: TextView
    private lateinit var txtStatus: TextView
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    private val rocket = Rocket(
        folder = R.drawable.img_dummy,
        title = "CRS-20",
        date = "July 03, 2020",
        status = "Success"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaunchBinding.inflate(layoutInflater)

        imgFolder = binding.img
        txtTitle = binding.txtTitle
        txtDate = binding.txtDate
        txtStatus = binding.txtStatus
        tabLayout = binding.tabLayout
        viewPager = binding.viewPager

        fillFragmentLayout()
        fillTabLayout()

        return binding.root
    }

    private fun fillFragmentLayout(){
        imgFolder.setImageResource(rocket.folder)
        txtTitle.text = rocket.title
        txtDate.text = rocket.date
        txtStatus.text = rocket.status
    }

    private fun fillTabLayout(){
        val tabAdapter = TabsPagerAdapter(requireContext(), requireActivity())

        viewPager.apply {
            adapter = tabAdapter
            currentItem = 0
        }

        TabLayoutMediator(tabLayout, viewPager){tab, pos->
            tab.text = tabAdapter.getTabTitle(pos)
        }.attach()
    }
}