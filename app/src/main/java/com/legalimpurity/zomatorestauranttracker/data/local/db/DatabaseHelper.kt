package com.legalimpurity.zomatorestauranttracker.data.local.db

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.db.NearbyRestaurantRecord
import io.reactivex.Observable
import io.reactivex.Single

interface DatabaseHelper {
    fun getGeocodeNearbyRestaurantsList(lat: Double, lon: Double): Observable<NearbyRestaurantRecord>
    fun getGeocodeResponse(lat: Double, lon: Double): Observable<List<Restaurant>?>
    fun setGeocodeResponse(lat: Double, lon: Double, listOfRestaurants: List<Restaurant>?) : Observable<Boolean>
}