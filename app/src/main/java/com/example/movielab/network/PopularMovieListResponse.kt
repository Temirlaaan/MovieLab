package com.example.movielab.network

import com.google.gson.annotations.SerializedName

data class PopularMovieListResponse(
    @SerializedName("results")
    val results: List<Result>,
) {
    data class Result(
        @SerializedName("id")
        val id: Int, // 453395
        @SerializedName("original_language")
        val originalLanguage: String, // en
        @SerializedName("poster_path")
        val posterPath: String, // /9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg
        @SerializedName("release_date")
        val releaseDate: String, // 2022-05-04
        @SerializedName("title")
        val title: String, // Doctor Strange in the Multiverse of Madness
        @SerializedName("vote_average")
        val voteAverage: Double,

        val overview: String// 7.5
    )
}
