package com.devpass.spaceapp.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentRocketBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RocketFragment : Fragment() {

    private lateinit var binding: FragmentRocketBinding
    private val viewModel: SpaceAppViewModel by viewModel()

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
            val intent = Intent(context, RocketDetailsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun dataSetup() {
        // TODO : passar o id por parametro
        viewModel.getRocketDetails("5e9d0d95eda69974db09d1ed")
        viewModel.resultRocketDetails.observe(viewLifecycleOwner) {
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