package com.example.movielab.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices{

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movie_id: Int): Call<MovieListDTO>
}