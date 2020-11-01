package com.example.kotlinapplication.model

data class MovieResponse(
    var page: Int,
    var total_pages: Int,
    var total_results: Int,
    var results: List<Movies>
)