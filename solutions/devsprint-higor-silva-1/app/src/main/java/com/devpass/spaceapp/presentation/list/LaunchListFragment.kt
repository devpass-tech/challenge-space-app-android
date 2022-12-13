package com.devpass.spaceapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentLaunchListBinding
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.presentation.adapter.NextLaunchesAdapter
import com.devpass.spaceapp.repository.NetworkChecker
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LaunchListFragment : Fragment() {

    @Inject
    lateinit var networkChecker: NetworkChecker

    private val viewModel: LaunchListViewModel by viewModels()

    private var launchList = arrayListOf<Launch>()

    private lateinit var binding: FragmentLaunchListBinding
    private lateinit var progressBar: ProgressBar
    private lateinit var txtMessage: TextView
    private lateinit var btnReconnect: Button

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

        progressBar = binding.progressBar
        txtMessage = binding.txtMessage
        btnReconnect = binding.btnReconnect

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isLoading.observe(viewLifecycleOwner) {
            showProgress(it)
        }

        viewModel.launchList.observe(viewLifecycleOwner) { viewModelLaunchList ->
            launchList.addAll(viewModelLaunchList)
            loadLaunchList()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            txtMessage.visibility = View.VISIBLE
            txtMessage.text = it
        }
    }

    override fun onResume() {
        super.onResume()

        if (launchList.isEmpty()) tryConnect() else loadLaunchList()
    }

    private fun loadLaunchList() {
        binding.progressBar.visibility = View.GONE
        binding.rvLaunchList.adapter =
            NextLaunchesAdapter(requireContext(), launchList, this::onClickListItem)
        binding.rvLaunchList.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun tryConnect() =
        if (networkChecker.hasInternet()) {
            viewModel.getLaunchs()
        } else {
            caseNoHaveInternet()

            Toast.makeText(
                requireContext(),
                resources.getString(R.string.txt_remains_unconnected),
                Toast.LENGTH_SHORT
            ).show()
        }

    private fun caseNoHaveInternet() {
        progressBar.visibility = View.GONE
        txtMessage.visibility = View.VISIBLE
        txtMessage.text = resources.getString(R.string.txt_no_connection)
        btnReconnect.visibility = View.VISIBLE

        btnReconnect.setOnClickListener {
            btnReconnect.visibility = View.GONE
            tryConnect()

        }
    }

    private fun showProgress(show: Boolean) {
        if (show) {
            txtMessage.text = resources.getString(R.string.txt_loading_launches)
        }

        txtMessage.visibility = if (show) View.VISIBLE else View.GONE
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun onClickListItem(nextLaunchClicked: Launch) {
        val action =
            LaunchListFragmentDirections.actionLaunchListFragmentToLaunchFragment(nextLaunchClicked)
        findNavController().navigate(action)
    }
}
