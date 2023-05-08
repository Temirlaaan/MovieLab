package com.example.movielab

import android.app.Application
import com.example.movielab.di.networkModule
import com.example.movielab.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin{
            androidContext(applicationContext)
            modules(arrayListOf(
                networkModule,
                viewModelModule
            ))
        }
    }

}