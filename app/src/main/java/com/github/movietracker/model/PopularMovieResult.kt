package com.github.movietracker.model

import android.os.Parcelable
import com.github.movietracker.data.Actor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResult(
    @SerialName("adult")
    val adult: Boolean,
    @SerialName("backdrop_path")
    var backdropPath: String,
    @SerialName("genre_ids")
    var genreIds: List<Int>,
    @SerialName("id")
    val id: Int,
    @SerialName("original_language")
    var originalLanguage: String,
    @SerialName("original_title")
    var originalTitle: String,
    val overview: String,
    @SerialName("popularity")
    var popularity: Double,
    @SerialName("poster_path")
    var posterPath: String,
    @SerialName("release_date")
    var releaseDate: String,
    @SerialName("title")
    val title: String,
    @SerialName("video")
    val video: Boolean,
    @SerialName("vote_average")
    var voteAverage:Double,
    @SerialName("vote_count")
    var voteCount: Int,
)

// @Parcelize
// data class Movie(
//     val id: Int = -1,
//     val title: String = "",
//     val overview: String = "",
//     val poster: String = "",
//     val backdrop: String = "",
//     val rating: Float = 0.0f,
//     val runtime: Int = 0,
//     val votes: Int = 0,
//     val age: Int = 0,
//     val like: Boolean = false,
//     val genres: List<Genre> = listOf(),
//     val actors: List<Actor> = listOf(),
// ) : Parcelable
