package com.github.movietracker.model

import kotlinx.serialization.Serializable

@Serializable
data class GenreResponse(
    val genres: List<Genre>?
)