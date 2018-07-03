package com.legalimpurity.zomatorestauranttracker.data.local.db

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.db.NearbyRestaurantRecord
import io.reactivex.Observable
import io.reactivex.Single

interface DatabaseHelper {
    fun getLocalGeocodeNearbyRestaurantsList(lat: Double, lon: Double): Observable<NearbyRestaurantRecord>
    fun getLocalGeocodeResponse(lat: Double, lon: Double): Observable<List<Restaurant>?>
    fun setLocalGeocodeResponse(lat: Double, lon: Double, listOfRestaurants: List<Restaurant?>?) : Observable<Boolean>
    fun addOrUpdateRestaurants(listOfRestaurants: List<Restaurant?>?) : Observable<Boolean>
}