package com.devpass.spaceapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.LaunchPadModel
import com.devpass.spaceapp.databinding.FragmentLaunchpadBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchpadFragment (
    private val idLaunchPad: String
    ) : Fragment() {

    private lateinit var binding: FragmentLaunchpadBinding
    private val viewModel: SpaceAppViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentLaunchpadBinding.inflate(inflater, container, false)

        viewModel.getLaunchpadDetails(idLaunchPad)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loading.show()
        dataSetup()
    }

    private fun configureClickable(launchPadModel: LaunchPadModel) {
        binding.viewMore.setOnClickListener {
            val intent = Intent(context, LaunchpadDetailsActivity::class.java)
            intent.putExtra("launchpad", launchPadModel)
            startActivity(intent)
        }
    }

    private fun dataSetup() {
        viewModel.resultLaunchpadDetails.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.name.text = it.name
                binding.locality.text = it.locality
                binding.region.text = it.region
                configureClickable(it)
                binding.cardView.visibility = View.VISIBLE
            } else {
                binding.viewMore.visibility = View.GONE
                binding.error.errorMessage.text = getString(R.string.launchpad_details_fail)
                binding.error.root.visibility = View.VISIBLE
            }

            binding.loading.hide()
        }
    }
}