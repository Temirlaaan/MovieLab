package com.example.movielab.movie.popular.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Popular(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val rating: Double,
    val posterURL: String,
    val lang: String,
    val overview: String
): Parcelable