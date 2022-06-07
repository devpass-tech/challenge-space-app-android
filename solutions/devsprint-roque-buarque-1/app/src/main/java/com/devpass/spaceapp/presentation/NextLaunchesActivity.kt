package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.repository.NextLaunchRepository
import com.devpass.spaceapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NextLaunchesActivity : AppCompatActivity() {
    private val nextLaunchesActivityBinding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(nextLaunchesActivityBinding.root)

        val repository = NextLaunchRepository.newInstance()
    }
}