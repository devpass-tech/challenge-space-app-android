package com.devpass.spaceapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.devpass.spaceapp.R
import kotlinx.android.synthetic.main.launch_details_fragment.*

class LaunchDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.launch_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        description_text.text = getString(R.string.launch_details_dummy_text)
        view_more_button.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Chamar LaunchDetailsActivity aqui",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}