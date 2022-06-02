package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.repository.NextLaunchRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NextLaunchesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = NextLaunchRepository.newInstance()
    }
}