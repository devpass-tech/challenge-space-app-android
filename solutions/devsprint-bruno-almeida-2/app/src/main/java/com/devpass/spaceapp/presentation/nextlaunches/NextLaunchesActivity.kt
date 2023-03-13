package com.devpass.spaceapp.presentation.nextlaunches


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.devpass.spaceapp.R
import com.devpass.spaceapp.RetrofitService
import com.devpass.spaceapp.data.datasource.LaunchesListDataSourceImpl
import com.devpass.spaceapp.data.repository.LaunchesListRepositoryImpl

class NextLaunchesActivity : AppCompatActivity() {

    val retrofit = RetrofitService
    val service =
    val dataSource = LaunchesListDataSourceImpl(service)
    val repository = LaunchesListRepositoryImpl(dataSource)
    val viewModel = NextLaunchesViewModel(repository)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.nextlaunchrecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}