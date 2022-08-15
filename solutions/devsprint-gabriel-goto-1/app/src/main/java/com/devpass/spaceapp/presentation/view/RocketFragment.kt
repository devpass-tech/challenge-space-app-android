package com.devpass.spaceapp.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devpass.spaceapp.databinding.FragmentRocketBinding
import com.devpass.spaceapp.presentation.RocketDetailsActivity

class RocketFragment : Fragment() {

    private var _binding: FragmentRocketBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRocketBinding.inflate(inflater, container, false)
        setUpView()

        binding.cardViewRocketFragment.setOnClickListener {

            val title = binding.textViewRocketFragmentTitle.text
            val info = binding.textViewRocketFragmentInfo.text

            Intent(requireActivity(), RocketDetailsActivity::class.java).also {

                it.putExtra("EXTRA_TITLE", title)
                it.putExtra("EXTRA_INFO", info)
                startActivity(it)

            }
        }

        return binding.root
    }

    private fun setUpView() {
        binding.imageViewRocketFragment
        binding.textViewRocketFragmentTitle.text = ""
        binding.textViewRocketFragmentInfo.text = ""
    }

    private fun navigateToRocketDetailsActivity(){


        }




    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}