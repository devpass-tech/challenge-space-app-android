package com.devpass.spaceapp.presentation.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devpass.spaceapp.R
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.presentation.launch.details.CardDetailsFragment
import com.devpass.spaceapp.presentation.launch.launchpad.CardLaunchpadFragment
import com.devpass.spaceapp.presentation.launch.rocket.CardRocketFragment

class TabsPagerAdapter(
    context: Context,
    activity: FragmentActivity,
    private val launch: Launch
) : FragmentStateAdapter(activity) {

    private val tabTitles: Array<String> =
        context.resources.getStringArray(R.array.tab_titles)

    override fun getItemCount() = 3

    override fun createFragment(position: Int) = when (position) {
        0 -> CardDetailsFragment().apply {
            arguments = Bundle().apply {
                putSerializable("selectedLaunch", launch)
            }
        }

        1 -> CardRocketFragment().apply {
            arguments = Bundle().apply {
                putSerializable("selectedRocket", launch.rocketDetails)
            }
        }

        else -> CardLaunchpadFragment().apply {
            arguments = Bundle().apply {
                putSerializable("selectedLaunchpad", launch.launchpadDetails)
            }
        }
    }

    fun getTabTitle(position: Int) = tabTitles[position]
}
