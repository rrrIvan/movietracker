package com.example.myapplication.local.model

data class Movie(
    val id: Int,
    val title: String,
    val poster: String,
    val ageLimit: Int,
    val rating: Int,
    val reviews: Int,
    val duration: Int,
    val tags: List<String>,
    val storyline: String,
    val isLiked: Boolean,
    val cast: List<Actor>
)
