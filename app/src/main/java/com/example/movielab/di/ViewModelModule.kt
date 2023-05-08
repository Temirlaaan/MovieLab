package com.example.movielab.di

import com.example.movielab.popular.PopularViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { PopularViewModel(get()) }

}