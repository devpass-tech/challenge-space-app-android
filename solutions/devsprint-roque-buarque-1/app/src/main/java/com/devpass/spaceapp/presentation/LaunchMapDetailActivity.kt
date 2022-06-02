package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityLaunchMapDetailBinding
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class LaunchMapDetailActivity : AppCompatActivity() {
    lateinit var launchMapDetailsBinding: ActivityLaunchMapDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchMapDetailsBinding = ActivityLaunchMapDetailBinding.inflate(layoutInflater)
        setContentView(launchMapDetailsBinding.root)

        val mapFragment =
            supportFragmentManager.findFragmentById(launchMapDetailsBinding.fragmentMap.id) as SupportMapFragment

        mapFragment.getMapAsync{ googleMaps ->


            googleMaps.setOnMapLoadedCallback {

            }
        }
    }
}