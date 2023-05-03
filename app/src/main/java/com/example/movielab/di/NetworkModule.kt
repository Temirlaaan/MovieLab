package com.example.movielab.di

import com.example.movielab.network.createApplicationService
import org.koin.dsl.module

val networkModule = module {
    single { createApplicationService("https://api.themoviedb.org/3/") }
}