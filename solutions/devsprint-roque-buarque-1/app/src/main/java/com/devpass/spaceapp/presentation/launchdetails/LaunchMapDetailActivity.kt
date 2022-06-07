package com.devpass.spaceapp.presentation.launchdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpass.spaceapp.databinding.ActivityLaunchMapDetailBinding
import com.devpass.spaceapp.presentation.utils.viewBinding
import com.google.android.gms.maps.SupportMapFragment

class LaunchMapDetailActivity : AppCompatActivity() {
    private val launchMapDetailsActivityBinding by viewBinding(ActivityLaunchMapDetailBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(launchMapDetailsActivityBinding.root)

        val mapFragment =
            supportFragmentManager.findFragmentById(launchMapDetailsActivityBinding.fragmentMap.id) as SupportMapFragment

        mapFragment.getMapAsync{ googleMaps ->


            googleMaps.setOnMapLoadedCallback {

            }
        }
    }
}