package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.devpass.spaceapp.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.devpass.spaceapp.databinding.ActivityLaunchpadDetailsScreenBinding
import com.devpass.spaceapp.utils.latitude
import com.devpass.spaceapp.utils.longitude

class LaunchpadDetailsScreenActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityLaunchpadDetailsScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLaunchpadDetailsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun setupToolbar() {
        val toolbar = binding.includeToolbar.tvToolbarTitle
        toolbar.text = resources.getString(R.string.label_launchpad)
        toolbar.gravity = Gravity.CENTER
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val launchpad = LatLng(latitude, longitude)
        val zoomLevel = 15f

        mMap.addMarker(MarkerOptions().position(launchpad))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(launchpad, zoomLevel))
    }
}