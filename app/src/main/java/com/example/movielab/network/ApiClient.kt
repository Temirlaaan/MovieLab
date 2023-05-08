package com.example.movielab.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


fun createApplicationService(baseUrl: String): ApiServices {
    val headerInterceptor = HeaderInterceptor()


    val client = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ApiServices::class.java)
}