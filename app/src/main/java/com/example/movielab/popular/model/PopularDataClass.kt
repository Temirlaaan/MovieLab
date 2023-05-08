package com.example.movielab.popular.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Popular(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val rating: Double,
    val posterURL: String
): Parcelable