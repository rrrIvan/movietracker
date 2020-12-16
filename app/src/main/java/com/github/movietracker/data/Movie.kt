package com.github.movietracker.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int = -1,
    val title: String = "",
    val overview: String = "",
    val poster: String = "",
    val backdrop: String = "",
    val rating: Float = 0.0f,
    val runtime: Int = 0,
    val votes: Int = 0,
    val age: Int = 0,
    val like: Boolean = false,
    val genres: List<Genre> = listOf(),
    val actors: List<Actor> = listOf(),

) : Parcelable