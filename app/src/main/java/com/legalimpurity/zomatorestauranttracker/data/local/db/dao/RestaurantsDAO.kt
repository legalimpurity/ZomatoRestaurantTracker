package com.legalimpurity.zomatorestauranttracker.data.local.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant

@Dao
interface RestaurantsDAO
{
    @Query("SELECT * FROM Restaurants where id IN (:listOfIds)")
    fun loadRestaurantsWithIds(listOfIds : String): List<Restaurant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(restaurants: List<Restaurant?>?)
}