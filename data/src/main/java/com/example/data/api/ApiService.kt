package com.example.challengelima.api

import com.example.challengelima.model.Movies
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("trending/{media_type}/week")
    fun getTrendingMovie( @Path("media_type") media: String, @Query("api_key") apiKey: String): Call<Movies>

}