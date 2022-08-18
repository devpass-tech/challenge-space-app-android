package com.devpass.spaceapp.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devpass.spaceapp.presentation.view.LaunchPadFragment
import com.devpass.spaceapp.presentation.view.RocketFragment
import com.devpass.spaceapp.presentation.view.LaunchDetailsFragment

private const val NUM_TABS = 3

class LaunchTabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                LaunchDetailsFragment()
            }
            1 -> {
                RocketFragment()
            }
            2 -> {
                LaunchPadFragment()
            }
            else -> {
                LaunchDetailsFragment()
            }
        }
    }
}