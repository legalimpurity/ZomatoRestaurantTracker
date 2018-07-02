package com.legalimpurity.zomatorestauranttracker.data.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.os.Parcelable

@Entity(tableName = "NearbyRestaurantRecords", primaryKeys = ["latitude","longitude"])
abstract class NearbyRestaurantRecord() : Parcelable {

    @ColumnInfo(name = "latitude")
    var latitude: Double? = null

    @ColumnInfo(name = "longitude")
    var longitude: Double? = null

}