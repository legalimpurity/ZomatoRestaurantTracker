package com.legalimpurity.zomatorestauranttracker.data.local.db

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review
import com.legalimpurity.zomatorestauranttracker.data.model.db.NearbyRestaurantRecord
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseHelperImplementation @Inject constructor(private val mAppDatabase: AppDatabase) : DatabaseHelper {

    override fun getLocalGeocodeNearbyRestaurantsList(lat: Double, lon: Double) = Observable.fromCallable<NearbyRestaurantRecord> {
        mAppDatabase.nearbyRestaurantsRecordsDAO().getRestaurantsList(lat,lon)
    }

    override fun getLocalGeocodeResponse(lat: Double, lon: Double): Observable<List<Restaurant?>?> = getLocalGeocodeNearbyRestaurantsList(lat,lon).map { nearbyRestaurantRecord ->
        nearbyRestaurantRecord.listOfIds?.let { mAppDatabase.restaurantsDAO().loadRestaurantsWithIds(it.split(",")) }
    }

    override fun setLocalGeocodeResponse(lat: Double, lon: Double, listOfRestaurants: List<Restaurant?>?) = Observable.fromCallable<Boolean> {
        var stringBufferForIds = StringBuffer()
        listOfRestaurants?.forEach { restaurant ->
            stringBufferForIds.append(restaurant?.id)
            stringBufferForIds.append(",")
        }
        stringBufferForIds.setLength(stringBufferForIds.length - 1)

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

    override fun addOrUpdateReviews(listOfReviews: List<Review?>?) = Observable.fromCallable {
        mAppDatabase.reviewsDAO().insertAll(listOfReviews)
        true
    }

}