package com.example.movielab.movie.comingSoon.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComingSoon(
    val title: String,
    val release_date: String,
    val rating: Double,
    val overview: String,
    val posterURL:String,
    val lang: String
) : Parcelable