package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.devpass.spaceapp.data.model.NextLaunchModel
import com.devpass.spaceapp.databinding.ActivityLaunchTabBinding
import com.google.android.material.tabs.TabLayoutMediator

const val NEXT_LAUNCH_MODEL = "nextLaunch"
private const val SUCCESS_LAUNCH = "Success"
private const val FAILURE_LAUNCH = "Failure"

class LaunchTabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchTabBinding
    private val nextLaunch: NextLaunchModel? by lazy {
        intent.getSerializableExtra(NEXT_LAUNCH_MODEL) as? NextLaunchModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val adapter = LaunchTabAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getString(adapter.tabTitles[position])
        }.attach()
        setup()
    }

    private fun setup() {
        binding.header.launchName.text = nextLaunch?.nameRocket
        binding.header.launchDate.text = nextLaunch?.date
        binding.header.launchStatus.text =
            if (nextLaunch?.status == true) SUCCESS_LAUNCH else FAILURE_LAUNCH

        Glide
            .with(this)
            .load(nextLaunch?.links?.patch?.small)
            .centerCrop()
            .into(binding.header.launchBadge)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}