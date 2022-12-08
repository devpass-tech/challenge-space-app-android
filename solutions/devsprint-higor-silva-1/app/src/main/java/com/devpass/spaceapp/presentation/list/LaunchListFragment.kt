package com.devpass.spaceapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentLaunchListBinding
import com.devpass.spaceapp.models.NextLaunchesModel
import com.devpass.spaceapp.presentation.adapter.NextLaunchesAdapter
import com.devpass.spaceapp.presentation.launch.LaunchFragment

class LaunchListFragment : Fragment() {

    private lateinit var binding: FragmentLaunchListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaunchListBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.rvLaunchList.adapter = NextLaunchesAdapter(
            List(20) {
                NextLaunchesModel(
                    image = R.drawable.ic_launcher_background,
                    title = "CRS 20 $it",
                    subtitle = "July 03, 2020",
                    status = "Success",
                    position = "92"
                )
            },
            this::onClickListItem
        )
        binding.rvLaunchList.layoutManager = LinearLayoutManager(requireContext())
    }

    fun onClickListItem(nextLaunchClicked: NextLaunchesModel){
        val fragment = LaunchFragment.newInstance(nextLaunchClicked)

        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, fragment, LaunchFragment.TAG_LAUNCH)
            .setTransition(TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}