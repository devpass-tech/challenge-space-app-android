package com.devpass.spaceapp.presentation.rocket

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.devpass.spaceapp.application.SpaceApp
import com.devpass.spaceapp.databinding.ActivityRocketDetailsBinding
import com.devpass.spaceapp.presentation.utils.viewBinding
import javax.inject.Inject

class RocketDetailsActivity : AppCompatActivity() {


    private val rocketDetailsActivityBinding by viewBinding(ActivityRocketDetailsBinding::inflate)
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: RocketDetailViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as SpaceApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(rocketDetailsActivityBinding.root)
    }
}