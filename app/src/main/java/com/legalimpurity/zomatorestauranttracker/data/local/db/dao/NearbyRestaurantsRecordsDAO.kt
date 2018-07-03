package com.legalimpurity.zomatorestauranttracker.data.local.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.db.NearbyRestaurantRecord

@Dao
interface NearbyRestaurantsRecordsDAO
{
    @Query("SELECT * FROM NearbyRestaurantRecords WHERE latitude = :latitude and longitude = :longitude")
    fun getRestaurantsList(latitude : Double, longitude: Double): NearbyRestaurantRecord

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(nearbyRestaurantRecords: NearbyRestaurantRecord)
}