package com.devpass.spaceapp.presentation.list

import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentLaunchListBinding
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.presentation.adapter.NextLaunchesAdapter
import com.devpass.spaceapp.repository.NetworkChecker
import com.devpass.spaceapp.repository.Repository
import com.devpass.spaceapp.repository.SpacexApi

class LaunchListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private lateinit var repository: Repository
    private lateinit var api: SpacexApi

    private var launchList = arrayListOf<Launch>()

    private lateinit var binding: FragmentLaunchListBinding

    private lateinit var progressBar: ProgressBar
    private lateinit var txtMessage: TextView
    private lateinit var btnReconnect: Button

    private lateinit var networkChecker: NetworkChecker

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

        networkChecker = NetworkChecker(
            ContextCompat.getSystemService(
                requireContext(),
                ConnectivityManager::class.java
            )
        )

        api = SpacexApi.getInstance()
        repository = Repository(api)
        viewModel = ListViewModel(repository)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tryConnect()

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            txtMessage.visibility = View.VISIBLE
            txtMessage.text = it
        }
    }

    fun initRecyclerView() {
        binding.rvLaunchList.adapter = NextLaunchesAdapter(launchList)
        binding.rvLaunchList.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun tryConnect(): Boolean {
        return if (networkChecker.hasInternet()) {
            viewModel.getLaunchs()

            caseHaveInternet()
            true
        } else {
            caseNoHaveInternet()
            false
        }
    }

    private fun caseHaveInternet() {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            showProgress(it)

            if (!it) {
                viewModel.launchList.observe(viewLifecycleOwner) { viewModelLaunchList ->
                    launchList.addAll(viewModelLaunchList)
                    Log.d("HSV", launchList.joinToString("\n"))
                    initRecyclerView()
                }
            }
        }
    }

    private fun caseNoHaveInternet() {
        progressBar.visibility = View.GONE
        txtMessage.visibility = View.VISIBLE
        txtMessage.text = resources.getString(R.string.txt_no_connection)
        btnReconnect.visibility = View.VISIBLE

        btnReconnect.setOnClickListener {
            if (tryConnect()) {
                btnReconnect.visibility = View.GONE
            } else {
                Toast.makeText(
                    requireContext(),
                    resources.getString(R.string.txt_remains_unconnected),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun showProgress(show: Boolean) {
        if (show) {
            txtMessage.text = resources.getString(R.string.txt_loading_launches)
        }

        txtMessage.visibility = if (show) View.VISIBLE else View.GONE
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }
}