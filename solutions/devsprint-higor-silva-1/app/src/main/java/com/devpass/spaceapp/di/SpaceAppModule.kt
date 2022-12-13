package com.devpass.spaceapp.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat
import com.devpass.spaceapp.repository.NetworkChecker
import com.devpass.spaceapp.repository.SpacexApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SpaceAppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): SpacexApi {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(SpacexApi::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkChecker(@ApplicationContext context: Context): NetworkChecker =
        NetworkChecker(
            ContextCompat.getSystemService(
                context,
                ConnectivityManager::class.java
            )
        )
}