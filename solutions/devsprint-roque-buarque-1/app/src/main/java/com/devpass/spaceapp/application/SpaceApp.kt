package com.devpass.spaceapp.application

import android.app.Application
import com.devpass.spaceapp.di.DaggerApplicationComponent

class SpaceApp: Application() {

    val appComponent = DaggerApplicationComponent.create()
}