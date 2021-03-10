package com.github.movietracker.data

import android.os.Parcelable
import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val id: Int,
    val name: String,
    val picture: String
)
