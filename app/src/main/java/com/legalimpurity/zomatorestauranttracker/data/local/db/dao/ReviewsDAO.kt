package com.legalimpurity.zomatorestauranttracker.data.local.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review

@Dao
interface ReviewsDAO
{
    @Query("SELECT * FROM Reviews where restaurantId = :restaurantId")
    fun loadReviewsByRestaurantIds(restaurantId : Long): List<Review>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(restaurants: List<Review?>?)
}