package com.devpass.spaceapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.RocketModel
import com.devpass.spaceapp.databinding.FragmentRocketBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

const val ROCKET_DETAILS_BUNDLE = "rocketDetails"

class RocketFragment (
    private val rocketId: String
        ) : Fragment() {

    private lateinit var binding: FragmentRocketBinding
    private val viewModel: SpaceAppViewModel by viewModel()
    private var rocketModel: RocketModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentRocketBinding.inflate(inflater, container, false)

        configureClickable()
        dataSetup()

        return binding.root
    }

    private fun configureClickable() {
        binding.cardViewRocket.setOnClickListener {
            rocketModel?.let {
                val intent = Intent(context, RocketDetailsActivity::class.java)
                intent.putExtra(ROCKET_DETAILS_BUNDLE, it)
                startActivity(intent)
            }
        }
    }

    private fun dataSetup() {
        viewModel.getRocketDetails(rocketId)
        viewModel.resultRocketDetails.observe(viewLifecycleOwner) {
            rocketModel = it
            if (it != null) {
                binding.rocketName.text = it.name
                binding.rocketDescription.text = it.description
                setRocketImage(it.image.first())
            } else {
                binding.cardViewRocket.visibility = View.GONE
                binding.error.errorMessage.text = getString(R.string.rocket_details_fail)
                binding.error.root.visibility = View.VISIBLE
            }
        }
    }

    private fun setRocketImage(imageUrl: String) {
        binding.apply {
            Glide.with(this@RocketFragment).load(imageUrl).into(rocketImage)
        }
    }
}