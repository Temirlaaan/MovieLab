package com.example.movielab.di

import com.example.movielab.movie.comingSoon.ComingSoonViewModel
import com.example.movielab.movie.popular.PopularViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { PopularViewModel(get()) }
    factory { ComingSoonViewModel(get())}

}