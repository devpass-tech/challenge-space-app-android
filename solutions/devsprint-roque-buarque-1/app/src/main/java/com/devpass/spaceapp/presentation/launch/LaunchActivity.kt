package com.devpass.spaceapp.presentation.launch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.application.SpaceApp
import javax.inject.Inject

class LaunchActivity: AppCompatActivity() {

    @Inject lateinit var viewModel: LaunchActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as SpaceApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}