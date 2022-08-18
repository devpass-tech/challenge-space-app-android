package com.devpass.spaceapp.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devpass.spaceapp.databinding.FragmentRocketBinding
import com.devpass.spaceapp.presentation.RocketDetailsActivity
import java.lang.reflect.Array.newInstance

class RocketFragment : Fragment() {

    private var _binding: FragmentRocketBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(context: Context, args: RocketDetailArgs): Intent {
            return Intent(context, RocketDetailsActivity::class.java).also {

                it.putExtra("EXTRA_ROCKET_DETAIL_ARGS", args)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRocketBinding.inflate(inflater, container, false)
        setUpView()

        binding.cardViewRocketFragment.setOnClickListener {

            val title = binding.textViewRocketFragmentTitle.text
            val info = binding.textViewRocketFragmentInfo.text

            //Intent(requireActivity(), RocketDetailsActivity::class.java).also {

            //it.putExtra("EXTRA_TITLE", title)
            //it.putExtra("EXTRA_INFO", info)
            //startActivity(it)

            //}


            val intent = RocketDetailsActivity.newInstance(requireContext(), args)
            startActivity(intent)

        }

        return binding.root
    }

    private fun setUpView() {
        binding.imageViewRocketFragment
        binding.textViewRocketFragmentTitle.text = ""
        binding.textViewRocketFragmentInfo.text = ""
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

@Parcelize
data class RocketDetailArgs(
    val title: String,
    val info: String,
    val image: String,
) : Parcelable



