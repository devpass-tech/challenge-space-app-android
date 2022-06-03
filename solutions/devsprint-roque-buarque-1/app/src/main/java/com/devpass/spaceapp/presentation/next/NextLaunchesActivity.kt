package com.devpass.spaceapp.presentation.next

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.repository.next.NextLaunchRepository

class NextLaunchesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = NextLaunchRepository.newInstance()
    }
}