package com.devpass.spaceapp.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.devpass.spaceapp.R
import com.devpass.spaceapp.data.model.NextLaunchesModel
import com.devpass.spaceapp.databinding.ActivityNextLaunchesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NextLaunchesActivity : AppCompatActivity() {

    private lateinit var adapter: LaunchAdapterItem
    private lateinit var binding: ActivityNextLaunchesBinding
    private val viewModel: SpaceAppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextLaunchesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = getString(R.string.next_launches_title)

        viewModel.fetchNextLaunches()
        viewModel.resultNextLaunches.observe(this) {
            setup(it)
        }
        viewModel.resultNextLaunchError.observe(this) {
            Log.e("Error next launch", it)
        }
    }

    private fun setup(list: NextLaunchesModel) {
        adapter = LaunchAdapterItem(list.docs) { nextLaunch ->
            val i = Intent(this, LaunchTabActivity::class.java)
            intent.putExtra(NEXT_LAUNCH_MODEL, nextLaunch)
            startActivity(i)
        }
        binding.listNextLaunches.adapter = adapter
    }

}