package com.example.movielab.comingSoon.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComingSoon(
    val title: String,
    val tagline: String,
    val release_date: String,
    val rating: String,
    val runtime: String,
    val overview: String

) : Parcelable