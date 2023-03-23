package com.devpass.spaceapp.presentation.nextlaunches


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import com.devpass.spaceapp.RetrofitService
import com.devpass.spaceapp.data.api.SpaceXAPIClient
import com.devpass.spaceapp.data.datasource.LaunchesListDataSourceImpl
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.data.repository.LaunchesListRepositoryImpl
import com.devpass.spaceapp.databinding.ActivityMainBinding
import com.devpass.spaceapp.presentation.LaunchActivity
import com.devpass.spaceapp.presentation.NextLaunchesAdapter

class NextLaunchesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NextLaunchesAdapter

    private val service = RetrofitService.retrofit.create(SpaceXAPIClient::class.java)
    private val dataSource = LaunchesListDataSourceImpl(service)
    private val repository = LaunchesListRepositoryImpl(dataSource)
    private val viewModel = NextLaunchesViewModel(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Definir o layout manager da RecyclerView
        binding.nextlaunchrecyclerview.layoutManager = LinearLayoutManager(this)


        viewModel.launchList.observe(this) {


            // Inicializar o adapter com os dados
            adapter = NextLaunchesAdapter(it, ::onLaunchClick)

            // Atribuir o adapter à RecyclerView
            binding.nextlaunchrecyclerview.adapter = adapter
        }
        viewModel.error.observe(this){
            it
        }
        viewModel.getNextLaunches(20)
    }

    private fun onLaunchClick(launch: NextLaunchesModel) {
        val intent = Intent(this, LaunchActivity::class.java)
        intent.putExtra("nextLaunch", launch) // <- corrigido para "nextLaunch"
        startActivity(intent)
    }
}