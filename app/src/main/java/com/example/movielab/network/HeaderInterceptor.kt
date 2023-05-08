package com.example.movielab.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

const val API_KEY = "02da584cad2ae31b564d940582770598"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val origin2 = chain.request()
        val url = origin2
            .url
            .newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()

        val origin = chain.request()
        val request = origin
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}