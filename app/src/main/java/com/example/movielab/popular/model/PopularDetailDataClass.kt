package com.example.movielab.popular.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailPopular(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val rating: Double,
    val posterURL: String,
    val lang: String,
    val overview: String
): Parcelable