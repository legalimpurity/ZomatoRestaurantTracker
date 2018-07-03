package com.legalimpurity.zomatorestauranttracker.data.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.os.Parcel
import android.os.Parcelable

@Entity(tableName = "NearbyRestaurantRecords", primaryKeys = ["latitude","longitude"])
class NearbyRestaurantRecord() : Parcelable {

    @ColumnInfo(name = "latitude")
    var latitude: Double? = null

    @ColumnInfo(name = "longitude")
    var longitude: Double? = null

    @ColumnInfo(name = "listOfIds")
    var listOfIds: String? = null

    constructor(parcel: Parcel) : this() {
        latitude = parcel.readValue(Double::class.java.classLoader) as? Double
        longitude = parcel.readValue(Double::class.java.classLoader) as? Double
        listOfIds = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(latitude)
        parcel.writeValue(longitude)
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