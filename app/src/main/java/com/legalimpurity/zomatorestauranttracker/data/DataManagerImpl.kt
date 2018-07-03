package com.legalimpurity.zomatorestauranttracker.data

import com.legalimpurity.zomatorestauranttracker.data.local.db.DatabaseHelper
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.remote.ApiDataHelper
import io.reactivex.Single
import javax.inject.Inject

class DataManagerImpl @Inject constructor(private val apiDataHelper: ApiDataHelper, private val databaseHelper: DatabaseHelper): DataManager {
    override fun getRemoteGeocodeResponse(lat: Double, long: Double): Single<List<Restaurant?>> = apiDataHelper.getRemoteGeocodeResponse(lat, long)
    override fun getLocalGeocodeNearbyRestaurantsList(lat: Double, lon: Double) = databaseHelper.getLocalGeocodeNearbyRestaurantsList(lat, lon)

    override fun getLocalGeocodeResponse(lat: Double, lon: Double) = databaseHelper.getLocalGeocodeResponse(lat, lon)
    override fun setLocalGeocodeResponse(lat: Double, lon: Double, listOfRestaurants: List<Restaurant>?) = databaseHelper.setLocalGeocodeResponse(lat, lon, listOfRestaurants)
}