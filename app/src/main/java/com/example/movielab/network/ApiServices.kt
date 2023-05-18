package com.example.movielab.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices{
    @GET("movie/popular")
    fun getPopularMovie(): Call<PopularMovieListResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovie(): Call<Soon>
}