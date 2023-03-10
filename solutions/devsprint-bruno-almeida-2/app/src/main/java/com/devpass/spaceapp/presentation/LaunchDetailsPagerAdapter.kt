import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devpass.spaceapp.data.model.LaunchpadModel
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.model.RocketModel
import com.devpass.spaceapp.presentation.LaunchDetailsFragment
import com.devpass.spaceapp.presentation.LaunchpadDetailsFragment
import com.devpass.spaceapp.presentation.RocketDetailsFragment

class LaunchDetailsPagerAdapter(fragmentActivity: FragmentActivity,
                                private val launch: NextLaunchesModel,
                                private val rocket: RocketModel,
                                private val launchpad: LaunchpadModel) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LaunchDetailsFragment.newInstance(launch)
            1 -> RocketDetailsFragment.newInstance(rocket)
            2 -> LaunchpadDetailsFragment.newInstance(launchpad)
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }
}
