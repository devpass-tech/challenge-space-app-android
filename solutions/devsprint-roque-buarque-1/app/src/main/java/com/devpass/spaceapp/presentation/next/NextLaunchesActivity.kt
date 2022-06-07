package com.devpass.spaceapp.presentation.next

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpass.spaceapp.data.repository.next.NextLaunchRepository
import com.devpass.spaceapp.databinding.ActivityMainBinding
import com.devpass.spaceapp.presentation.utils.viewBinding

class NextLaunchesActivity : AppCompatActivity() {

    private val nextLaunchesActivityBinding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(nextLaunchesActivityBinding.root)

        val repository = NextLaunchRepository.newInstance()
    }
}