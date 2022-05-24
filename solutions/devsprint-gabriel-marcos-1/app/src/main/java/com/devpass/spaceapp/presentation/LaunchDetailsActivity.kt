package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.LaunchDetailsActivityBinding

class LaunchDetailsActivity : AppCompatActivity() {

    private lateinit var binding: LaunchDetailsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LaunchDetailsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.tab_title_one)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}