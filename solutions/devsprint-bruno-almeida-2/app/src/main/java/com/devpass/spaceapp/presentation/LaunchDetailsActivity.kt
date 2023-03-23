package com.devpass.spaceapp.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.R
import com.devpass.spaceapp.databinding.ActivityLaunchDetailsBinding

private const val ARG_LAUNCH = "fullLaunchDescription"

class LaunchDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLaunchDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar a Toolbar como a ActionBar da Activity
        setSupportActionBar(binding.toolbar2)

        // Habilitar o botão de voltar na Toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Definir o ícone personalizado de retorno na Toolbar
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_arrow)

        // Recuperar o objeto launch da intent
        val details = intent.getCharSequenceExtra(ARG_LAUNCH)

        // Preencher os campos com as informações do objeto launch
        binding.launchDescriptionTextView.text = details
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // Quando o botão de voltar na Toolbar é pressionado, finaliza a activity atual
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}