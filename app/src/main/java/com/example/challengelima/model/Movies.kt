package com.example.challengelima.model

data class Movies(
    var page: Int?,
    var results: List<Movie?>?,
    var total_pages: Int?,
    var total_results: Int?
)