package com.example.myapplication.data

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val id: Int = -1,
    val title: String = "",
    val overview: String = "",
    val poster: String = "",
    val backdrop: String = "",
    val ratings: Float = 0.0f,
    val runtime: Int = 0,
    val votes: Int = 0,
    val age: Int = 0,
    val is_like: Boolean = false,
    val genres: List<Genre> = listOf(),
    val actors: List<Actor> = listOf(),

): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readBoolean(),
        parcel.createTypedArrayList(Genre)!!,
        parcel.createTypedArrayList(Actor)!!,

    )

    override fun writeToParcel(out_parcel: Parcel, flags: Int) {
        out_parcel.writeInt(id)
        out_parcel.writeString(title)
        out_parcel.writeString(overview)
        out_parcel.writeString(poster)
        out_parcel.writeString(backdrop)
        out_parcel.writeFloat(ratings)
        out_parcel.writeInt(runtime)
        out_parcel.writeInt(votes)
        out_parcel.writeInt(age)
        out_parcel.writeBoolean(is_like)
        out_parcel.writeTypedList(genres)
        out_parcel.writeTypedList(actors)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {

        override fun createFromParcel(in_parcel: Parcel): Movie {
            return Movie(in_parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}

