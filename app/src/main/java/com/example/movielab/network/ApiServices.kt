package com.example.movielab.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices{

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Call<PopularMovieDetails>

    @GET("movie/popular")
    fun getPopularMovie(): Call<PopularMovieListResponse>

}