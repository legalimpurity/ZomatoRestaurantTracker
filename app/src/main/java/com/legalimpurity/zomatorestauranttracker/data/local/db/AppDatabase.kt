package com.legalimpurity.zomatorestauranttracker.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.legalimpurity.zomatorestauranttracker.data.local.db.dao.NearbyRestaurantsRecordsDAO
import com.legalimpurity.zomatorestauranttracker.data.local.db.dao.RestaurantsDAO
import com.legalimpurity.zomatorestauranttracker.data.local.db.dao.ReviewsDAO
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review
import com.legalimpurity.zomatorestauranttracker.data.model.db.NearbyRestaurantRecord

@Database(entities = [Restaurant::class, NearbyRestaurantRecord::class, Review::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantsDAO(): RestaurantsDAO
    abstract fun nearbyRestaurantsRecordsDAO(): NearbyRestaurantsRecordsDAO
    abstract fun reviewsDAO(): ReviewsDAO
}