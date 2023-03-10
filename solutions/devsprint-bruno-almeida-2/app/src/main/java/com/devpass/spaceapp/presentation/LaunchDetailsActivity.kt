package com.devpass.spaceapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.ActivityLaunchDetailsBinding

class LaunchDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLaunchDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar o objeto launch da intent
        val launch = intent.getSerializableExtra("nextLaunch") as NextLaunchesModel

        // Preencher os campos com as informações do objeto launch
        binding.launchTitleTextView.text = launch.name
        binding.launchDateTextView.text = launch.date.toString()
        binding.launchStatusTextView.text = launch.status.toString()
        if(launch.image.isEmpty()) {
            // caso a URL da imagem seja nula ou vazia, carrega uma imagem padrão
            Glide.with(this)
                .load(R.drawable.space_logo)
                .circleCrop()
                .into(binding.launchImage)
        } else {
            // carrega a imagem usando Glide
            Glide.with(this)
                .load(launch.image)
                .circleCrop()
                .into(binding.launchImage)
        }

        // Cria uma instância do LaunchDetailsFragment
        val launchDetailsFragment = LaunchDetailsFragment.newInstance(launch)

// Adiciona o fragmento à atividade
        supportFragmentManager.beginTransaction()
            .add(R.id.container, launchDetailsFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}