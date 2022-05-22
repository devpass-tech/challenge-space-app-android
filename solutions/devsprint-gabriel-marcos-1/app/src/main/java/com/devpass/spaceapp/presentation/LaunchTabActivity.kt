package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.databinding.ActivityLaunchTabBinding
import com.google.android.material.tabs.TabLayoutMediator

class LaunchTabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val adapter = LaunchTabAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getString(adapter.tabTitles[position])
        }.attach()
    }
}