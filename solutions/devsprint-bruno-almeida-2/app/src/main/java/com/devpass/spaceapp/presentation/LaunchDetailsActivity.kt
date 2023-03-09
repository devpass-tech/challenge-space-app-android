package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityLaunchDetailsBinding

class LaunchDetailsActivity : AppCompatActivity() {

    private var launchNumber: Int = 0
    private var launchImageUrl: String? = null
    private var launchName: String? = null
    private var launchDate: Int = 0
    private var launchStatus: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLaunchDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar os dados do Bundle
        launchNumber = intent.getIntExtra("launchNumber", 0)
        launchName = intent.getStringExtra("launchName")
        launchDate = intent.getIntExtra("launchDate", 0)
        launchStatus = intent.getBooleanExtra("launchStatus", false)
        launchImageUrl = intent.getStringExtra("launchImageUrl")


        if(launchImageUrl.isNullOrEmpty()) {
            // caso a URL da imagem seja nula ou vazia, carrega uma imagem padrão
            Glide.with(this)
                .load(R.drawable.ic_launcher_background)
                .into(binding.launchImage)
        } else {
            // carrega a imagem usando Glide
            Glide.with(this)
                .load(launchImageUrl)
                .circleCrop()
                .into(binding.launchImage)
        }

        binding.launchTitle.text = launchName

    }
}