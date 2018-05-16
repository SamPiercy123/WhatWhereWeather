package com.example.sampiercy.whatwhereweather.data.model

import android.os.Parcel
import android.os.Parcelable

data class Coord(val lat: Float, val lon: Float): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readFloat(),
            parcel.readFloat())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(lat)
        parcel.writeFloat(lon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coord> {
        override fun createFromParcel(parcel: Parcel): Coord {
            return Coord(parcel)
        }

        override fun newArray(size: Int): Array<Coord?> {
            return arrayOfNulls(size)
        }
    }
}