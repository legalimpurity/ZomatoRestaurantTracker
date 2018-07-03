package com.legalimpurity.zomatorestauranttracker.data.local.db

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.db.NearbyRestaurantRecord
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseHelperImplementation @Inject constructor(private val mAppDatabase: AppDatabase) : DatabaseHelper {

    override fun getLocalGeocodeNearbyRestaurantsList(lat: Double, lon: Double) = Observable.fromCallable<NearbyRestaurantRecord> {
        mAppDatabase.nearbyRestaurantsRecordsDAO().getRestaurantsList(lat,lon)
    }

    override fun getLocalGeocodeResponse(lat: Double, lon: Double) = getLocalGeocodeNearbyRestaurantsList(lat,lon).map { nearbyRestaurantRecord ->
        nearbyRestaurantRecord.listOfIds?.let { mAppDatabase.restaurantsDAO().loadRestaurantsWithIds(it) }
    }

    override fun setLocalGeocodeResponse(lat: Double, lon: Double, listOfRestaurants: List<Restaurant?>?) = Observable.fromCallable<Boolean> {
        var stringBufferForIds = StringBuffer()
        listOfRestaurants?.forEach { restaurant ->
            stringBufferForIds.append(restaurant?.id)
            stringBufferForIds.append(",")
        }
        val nearbyRestaurantRecord = NearbyRestaurantRecord()
        nearbyRestaurantRecord.latitude = lat
        nearbyRestaurantRecord.longitude = lon
        nearbyRestaurantRecord.listOfIds = stringBufferForIds.toString()
        mAppDatabase.nearbyRestaurantsRecordsDAO().insert(nearbyRestaurantRecord)
        true
    }

    override fun addOrUpdateRestaurants(listOfRestaurants: List<Restaurant?>?) = Observable.fromCallable {
        mAppDatabase.restaurantsDAO().insertAll(listOfRestaurants)
        true
    }
}