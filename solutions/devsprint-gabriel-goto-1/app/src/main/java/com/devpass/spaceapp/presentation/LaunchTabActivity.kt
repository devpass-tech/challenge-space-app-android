package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpass.spaceapp.databinding.ActivityLauchTabBinding
import com.devpass.spaceapp.presentation.adapters.LaunchTabAdapter
import com.google.android.material.tabs.TabLayoutMediator

class LaunchTabActivity : AppCompatActivity() {

    private val launchArray = arrayOf(
        "DETAILS",
        "ROCKET",
        "LAUNCHPAD"
    )

    private lateinit var binding: ActivityLauchTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLauchTabBinding.inflate(layoutInflater)

        val viewPager = binding.viewPagerLaunchTab
        val tabLayout = binding.tabLayoutLaunchTab

        val adapter = LaunchTabAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = launchArray[position]
        }.attach()

        setContentView(binding.root)
    }
}