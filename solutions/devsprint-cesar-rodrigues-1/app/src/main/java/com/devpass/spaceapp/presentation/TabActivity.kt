package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityTabBinding
import com.devpass.spaceapp.launchCellView.RocketFragment

class TabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(FragmentDetails(), RocketFragment(), FragmentLaunchpad())
        val fragmentsPageTitle = listOf("Details", "Rocket", "Launchpad")
        val viewPagerAdapter = ViewPagerAdapter(
            fragments = fragments,
            fragmentManager = supportFragmentManager,
            tittles = fragmentsPageTitle
        )

        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}