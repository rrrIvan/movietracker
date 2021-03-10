package com.github.movietracker.model

import android.content.Context
import android.os.Parcelable
import com.example.movietracker.R
import com.github.movietracker.data.Actor
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    var popularity: Double,
    var voteCount: Int,
    var video: Boolean,
    var posterPath: String,
    var id: Int,
    var adult: Boolean,
    var backdropPath: String,
    var originalLanguage: String,
    var originalTitle: String,
    var genreIds: List<Int>,
    var title: String,
    // var actorIds: List<Int>?,
    var voteAverage: Double,
    var overview: String,
    var releaseDate: String,
    var runtime:  String,


    var isFavorite: Boolean = false,
    var genres: MutableList<Genre> = mutableListOf(),
    var actorList: List<Actor> = listOf()
) {
    fun getAgeLimit(context: Context): String {
        return if (adult) {
           context.getString(R.string.adult_age_limit)
        } else {
            context.getString(R.string.no_age_limit)
        }
    }

    fun getRating() = voteAverage / 2

    fun getGenreNames(): String {
        genres.let { genres ->
            return buildString {
                if (genres.size > 1) {
                    for (index in 0..genres.size - 2) {
                        append(genres[index].name).append(", ")
                    }
                }
                append(genres.last().name)
            }
        }
        return ""
    }
}
