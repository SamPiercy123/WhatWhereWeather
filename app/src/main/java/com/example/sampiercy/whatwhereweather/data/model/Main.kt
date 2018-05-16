package com.example.sampiercy.whatwhereweather.data.model

import android.os.Parcel
import android.os.Parcelable

data class Main(val humidity: Int, val pressure: Int, val temp: Float,
                val temp_max: Float, val temp_min: Float): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readFloat(),
            parcel.readFloat(),
            parcel.readFloat())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(humidity)
        parcel.writeInt(pressure)
        parcel.writeFloat(temp)
        parcel.writeFloat(temp_max)
        parcel.writeFloat(temp_min)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Main> {
        override fun createFromParcel(parcel: Parcel): Main {
            return Main(parcel)
        }

        override fun newArray(size: Int): Array<Main?> {
            return arrayOfNulls(size)
        }
    }
}