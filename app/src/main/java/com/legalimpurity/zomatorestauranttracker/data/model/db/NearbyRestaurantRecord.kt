package com.legalimpurity.zomatorestauranttracker.data.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.os.Parcel
import android.os.Parcelable
import io.reactivex.annotations.NonNull

@Entity(tableName = "NearbyRestaurantRecords", primaryKeys = ["latitude","longitude"])
class NearbyRestaurantRecord() : Parcelable {

    @NonNull
    @ColumnInfo(name = "latitude")
    var latitude: Double = 0.0

    @NonNull
    @ColumnInfo(name = "longitude")
    var longitude: Double = 0.0

    @ColumnInfo(name = "listOfIds")
    var listOfIds: String? = null

    constructor(parcel: Parcel) : this() {
        latitude = parcel.readDouble()
        longitude = parcel.readDouble()
        listOfIds = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
        parcel.writeString(listOfIds)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NearbyRestaurantRecord> {
        override fun createFromParcel(parcel: Parcel): NearbyRestaurantRecord {
            return NearbyRestaurantRecord(parcel)
        }

        override fun newArray(size: Int): Array<NearbyRestaurantRecord?> {
            return arrayOfNulls(size)
        }
    }

}