package com.devpass.spaceapp.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devpass.spaceapp.data.model.NextLaunchesModel

class LaunchDetailsPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val launch: NextLaunchesModel
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LaunchDetailsFragment.newInstance(launch)
            1 -> RocketDetailsFragment.newInstance(launch)
            2 -> LaunchpadDetailsFragment.newInstance(launch)
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }
}


