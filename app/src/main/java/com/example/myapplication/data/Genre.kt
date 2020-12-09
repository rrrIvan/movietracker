package com.example.myapplication.data

import android.os.Parcel
import android.os.Parcelable

data class Genre(val id: Int, val name: String): Parcelable {
    override fun toString(): String {
        return name
    }

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(out_parcel: Parcel, flags: Int) {
        out_parcel.writeInt(id)
        out_parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Genre> {

        override fun createFromParcel(in_parcel: Parcel): Genre {
            return Genre(in_parcel)
        }

        override fun newArray(size: Int): Array<Genre?> {
            return arrayOfNulls(size)
        }
    }
}
