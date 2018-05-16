package com.example.sampiercy.whatwhereweather.data.model

import android.os.Parcel
import android.os.Parcelable

data class WeatherItem(val clouds: Clouds, val coord: Coord, val dt: Long, val id: Int, val main: Main, val name: String,
                       val weather: List<Weather>, val wind: Wind) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(Clouds::class.java.classLoader),
            parcel.readParcelable(Coord::class.java.classLoader),
            parcel.readLong(),
            parcel.readInt(),
            parcel.readParcelable(Main::class.java.classLoader),
            parcel.readString(),
            parcel.createTypedArrayList(Weather),
            parcel.readParcelable(Wind::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(clouds, flags)
        parcel.writeParcelable(coord, flags)
        parcel.writeLong(dt)
        parcel.writeInt(id)
        parcel.writeParcelable(main, flags)
        parcel.writeString(name)
        parcel.writeTypedList(weather)
        parcel.writeParcelable(wind, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherItem> {
        override fun createFromParcel(parcel: Parcel): WeatherItem {
            return WeatherItem(parcel)
        }

        override fun newArray(size: Int): Array<WeatherItem?> {
            return arrayOfNulls(size)
        }
    }


}