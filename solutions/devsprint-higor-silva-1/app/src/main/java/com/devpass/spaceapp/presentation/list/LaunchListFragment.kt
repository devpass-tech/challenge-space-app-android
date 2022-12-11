package com.devpass.spaceapp.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.FragmentLaunchListBinding
import com.devpass.spaceapp.models.Launch
import com.devpass.spaceapp.models.NextLaunchesModel
import com.devpass.spaceapp.presentation.adapter.NextLaunchesAdapter
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

        api = SpacexApi.getInstance()
        repository = Repository(api)
        viewModel = ListViewModel(repository)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isLoading.observe(viewLifecycleOwner){
            showProgress(it)

            if(!it){
                viewModel.launchList.observe(viewLifecycleOwner){
                    launchList.addAll(it)
                    Log.d("HSV", launchList.joinToString("\n"))
                    initRecyclerView()
                }
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner){
            txtMessage.visibility = View.VISIBLE
            txtMessage.text = "Algum erro acontenceu"
        }
    }

    fun initRecyclerView() {
        binding.rvLaunchList.adapter = NextLaunchesAdapter(launchList)
        binding.rvLaunchList.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun showProgress(show: Boolean){
        if(show){
            txtMessage.text = "Carregando ultimos Lançamentos"
        }

        txtMessage.visibility = if(show) View.VISIBLE else View.GONE
        progressBar.visibility = if(show) View.VISIBLE else View.GONE
    }
}