package com.github.movietracker.network

import com.github.movietracker.model.PopularMovieResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val results: List<PopularMovieResult>,
    val total_pages: Int,
    val total_results: Int
)