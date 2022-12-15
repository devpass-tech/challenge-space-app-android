package com.devpass.spaceapp.presentation.launch.launchpad

import com.devpass.spaceapp.R
import com.devpass.spaceapp.getLatLng
import com.devpass.spaceapp.models.Location
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class AppMapFragment : SupportMapFragment() {

    fun initMap(map: GoogleMap?, location: Location) {
        map?.run {
            uiSettings.isMyLocationButtonEnabled = false
            uiSettings.isMapToolbarEnabled = false

            animateCamera(CameraUpdateFactory.newLatLngZoom(location.getLatLng(), 13F))
            setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map_style))

            addMarker(MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.img_location_marker))
                .position(location.getLatLng())
                .title(location.nameLocation)
                .snippet(location.region))
        }
    }

}