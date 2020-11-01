package com.example.kotlinapplication.rest

import com.example.kotlinapplication.model.MovieResponse
import com.example.kotlinapplication.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("top_rated?")
    fun getTopRatedMovies(@Query("api_key") apikey: String): Call<MovieResponse>

    @GET("{id}")
    fun getMovieDetails(@Path("id") id: Int, @Query("api_key") apiKey: String): Call<Movies>
}