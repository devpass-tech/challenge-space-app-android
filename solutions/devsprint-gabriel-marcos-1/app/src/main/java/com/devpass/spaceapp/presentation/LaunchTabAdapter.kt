package com.devpass.spaceapp.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devpass.spaceapp.R

class LaunchTabAdapter(fa: FragmentActivity) :
    FragmentStateAdapter(fa) {

    val tabTitles = listOf(R.string.tab_title_one, R.string.tab_title_two, R.string.tab_title_three)
    private val fragments = listOf(DetailsFragment(), RocketFragment(), LaunchpadFragment("5e9e4502f509092b78566f87"))

    override fun getItemCount(): Int {
        return tabTitles.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}