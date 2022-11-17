package com.example.challengelima.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    val interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        .addInterceptor(interceptor)

    val gson = GsonBuilder()
        .setLenient()
        .create()

    var apiClient = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(httpClient.build())
        .build()
        .create(ApiService::class.java)

}