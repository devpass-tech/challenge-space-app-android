package com.devpass.spaceapp.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devpass.spaceapp.R

class LaunchTabAdapter(
    fa: FragmentActivity,
    private val details: String,
    private val launchId: String,
    private val rocketId: String) :
    FragmentStateAdapter(fa) {

    val tabTitles = listOf(R.string.tab_title_one, R.string.tab_title_two, R.string.tab_title_three)
    private val fragments = listOf(DetailsFragment(details), RocketFragment(rocketId), LaunchpadFragment(launchId))

    override fun getItemCount(): Int {
        return tabTitles.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}