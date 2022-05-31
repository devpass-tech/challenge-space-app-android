package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.devpass.spaceapp.R
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class LaunchMapDetailActivity : AppCompatActivity() {
    private lateinit var textViewLaunchMapDetailName: TextView
    private lateinit var textViewLaunchMapDetailAddress: TextView
    private lateinit var textViewLaunchMapDetailState: TextView
    private lateinit var textViewLaunchMapDetailLaunchAttempts: TextView
    private lateinit var textViewLaunchMapDetailLaunchSuccesses: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_map_detail)

        // O código comentado seria referente ao objeto recebido da nossa ViewModel.

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment

        val toolbarTitle : TextView = findViewById(R.id.toolbar_title)
        //toolbarTitle.text = launchDetailUiModel.name

        mapFragment.getMapAsync{ googleMaps ->
            googleMaps.addMarker(
                MarkerOptions()
                //.title(launchDetailUiModel.name)
                //.position(launchDetailUiModel.latLng)
            )

            googleMaps.setOnMapLoadedCallback {
                val bounds = LatLngBounds.builder()
                //bounds.include(launchDetailUiModel.latLng)
                //googleMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(launchDetailUiModel.latLng, 10f))
            }
        }

        textViewLaunchMapDetailName = findViewById(R.id.text_view_launch_map_detail_name)
        textViewLaunchMapDetailAddress = findViewById(R.id.text_view_launch_map_detail_address)
        textViewLaunchMapDetailState = findViewById(R.id.text_view_launch_map_detail_state)
        textViewLaunchMapDetailLaunchAttempts =
            findViewById(R.id.text_view_launch_map_detail_launch_attempts)
        textViewLaunchMapDetailLaunchSuccesses =
            findViewById(R.id.text_view_launch_map_detail_launch_successes)
        //setLaunchInfo(launchDetailUiModel)

    }

    private fun setLaunchInfo(launchDetailUiModel: Any) {
        //textViewLaunchMapDetailName.text = launchDetailUiModel.name
        //textViewLaunchMapDetailAddress.text = launchDetailUiModel.address
        //textViewLaunchMapDetailState.text = launchDetailUiModel.state
        /*textViewLaunchMapDetailLaunchAttempts.text = launchDetailUiModel.launchAttempts.let {
            getString(R.string.launch_attempts) + " $it"
        }*/
        /*textViewLaunchMapDetailLaunchSuccesses.text = launchDetailUiModel.launchSuccesses.let {
            getString(R.string.launch_successes) + " $it"
        }*/
    }
}