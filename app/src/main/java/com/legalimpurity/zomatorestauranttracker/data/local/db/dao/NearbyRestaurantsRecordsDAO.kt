package com.legalimpurity.zomatorestauranttracker.data.local.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant

@Dao
interface NearbyRestaurantsRecordsDAO
{
    @Query("SELECT * FROM Restaurants")
    fun loadAll(): List<Restaurant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(attTimeMix: List<Restaurant>)
}