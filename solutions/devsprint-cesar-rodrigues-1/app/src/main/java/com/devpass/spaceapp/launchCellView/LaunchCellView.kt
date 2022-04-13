package com.devpass.spaceapp.launchCellView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityLaunchCellViewBinding

class LaunchCellView : AppCompatActivity() {
    private lateinit var binding: ActivityLaunchCellViewBinding
    private lateinit var adapter: LaunchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchCellViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycleView()
        initListLaunches()
    }

    private fun initListLaunches() {
        val list = listOf(
            LaunchModel(R.drawable.crs, "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "FalconSat", "July 03, 2020", "Success"),
        )
        adapter.updateList(list)
    }

    private fun setupRecycleView() {
        adapter = LaunchAdapter()
        binding.rvLaunches.adapter = adapter
        binding.rvLaunches.layoutManager = LinearLayoutManager(this)
    }
}