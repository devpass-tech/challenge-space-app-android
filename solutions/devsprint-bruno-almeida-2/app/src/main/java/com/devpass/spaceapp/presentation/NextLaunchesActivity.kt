package com.devpass.spaceapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.ActivityMainBinding


class NextLaunchesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NextLaunchesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Definir o layout manager da RecyclerView
        binding.nextlaunchrecyclerview.layoutManager = LinearLayoutManager(this)

        // Inicializar o adapter com os dados
        adapter = NextLaunchesAdapter(getData(), ::onLaunchClick)

        // Atribuir o adapter à RecyclerView
        binding.nextlaunchrecyclerview.adapter = adapter

    }

     private fun onLaunchClick(launch: NextLaunchesModel) {
        val intent = Intent(this, LaunchDetailsActivity::class.java)
        intent.putExtra("nextLaunch", launch) // <- corrigido para "nextLaunch"
        startActivity(intent)
    }


    // Função temporária para gerar os dados
    private fun getData(): List<NextLaunchesModel> {
        val data = mutableListOf<NextLaunchesModel>()
        for (i in 1..10) {
            data.add(
                NextLaunchesModel(
                    i,
                    "Rocket $i",
                    i * 1000000,
                    i % 2 == 0,
                    "https://via.placeholder.com/150?text=Rocket+$i"
                )
            )
        }
        return data
    }
}

