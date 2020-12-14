package com.example.movietracker.data

import android.os.Parcel
import android.os.Parcelable

data class Actor(
    val id: Int,
    val name: String,
    val picture: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(out_parcel: Parcel, flags: Int) {
        out_parcel.writeInt(id)
        out_parcel.writeString(name)
        out_parcel.writeString(picture)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Actor> {

        override fun createFromParcel(in_parcel: Parcel): Actor {
            return Actor(in_parcel)
        }

        override fun newArray(size: Int): Array<Actor?> {
            return arrayOfNulls(size)
        }
    }
}
