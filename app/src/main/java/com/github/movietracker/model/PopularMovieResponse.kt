package com.github.movietracker.model

import com.github.movietracker.model.PopularMovieResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val movies: List<PopularMovieResult>,
    val total_pages: Int,
    val total_results: Int
)