package com.example.kotlinapplication.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {
        val baseUrl: String = "https://api.themoviedb.org/3/movie/"
        var retrofit: Retrofit? = null
        val client: Retrofit?
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder().baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }

                return retrofit
            }
    }
}