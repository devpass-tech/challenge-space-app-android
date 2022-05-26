package com.devpass.spaceapp

import android.app.Application
import com.devpass.spaceapp.di.spaceModule
import org.koin.core.context.startKoin

class SpaceAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(spaceModule)
        }
    }
}