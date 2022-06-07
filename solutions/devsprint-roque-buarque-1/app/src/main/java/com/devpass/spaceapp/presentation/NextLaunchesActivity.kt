package com.devpass.spaceapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpass.spaceapp.data.repository.NextLaunchRepository
import com.devpass.spaceapp.databinding.ActivityMainBinding

class NextLaunchesActivity : AppCompatActivity() {
    private val nextLaunchesActivityBinding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(nextLaunchesActivityBinding.root)

        val repository = NextLaunchRepository.newInstance()
    }
}