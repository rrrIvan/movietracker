package com.example.myapplication.local.model

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster: String,
    val backdrop: String,
    val ratings: Float,
    val adult: Boolean,
    val runtime: Int,
    val genres: List<Genre>,
    val actors: List<Actor>
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readBoolean(),
        parcel.readInt(),
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
        out_parcel.writeBoolean(adult)
        out_parcel.writeInt(runtime)
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

