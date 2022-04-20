package com.devpass.spaceapp.launchCellView

import android.os.Bundle
import android.view.Gravity
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

        setupToolbar()
        setupRecycleView()
        initListLaunches()
    }

    private fun setupToolbar() {
        val toolbar = binding.includeToolbar.tvToolbarTitle
        toolbar.text = resources.getString(R.string.app_name)
        toolbar.gravity = Gravity.START
    }

    private fun initListLaunches() {
        val list = listOf(
            LaunchModel(R.drawable.crs, "#91", "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "#90", "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "#89", "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "#88", "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "#87", "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "#86", "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "#85", "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "#84", "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "#83", "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "#82", "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "#81", "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "#80", "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "#79", "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "#78", "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "#77", "FalconSat", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.crs, "#76", "CRS-20", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.starlink, "#75", "Starlink 4-2", "July 03, 2020", "Success"),
            LaunchModel(R.drawable.falcon_sat, "#74", "FalconSat", "July 03, 2020", "Success"),
        )
        adapter.submitList(list)
    }

    private fun setupRecycleView() {
        adapter = LaunchAdapter()
        binding.rvLaunches.adapter = adapter
        binding.rvLaunches.layoutManager = LinearLayoutManager(this)
    }
}