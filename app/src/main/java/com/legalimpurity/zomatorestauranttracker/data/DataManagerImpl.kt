package com.legalimpurity.zomatorestauranttracker.data

import com.legalimpurity.zomatorestauranttracker.data.local.db.DatabaseHelper
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.remote.ApiDataHelper
import com.legalimpurity.zomatorestauranttracker.util.internetstateprovider.InternetStateProvider
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DataManagerImpl @Inject constructor(private val apiDataHelper: ApiDataHelper, private val databaseHelper: DatabaseHelper, private val internetStateProvider: InternetStateProvider): DataManager {
    override fun getRemoteGeocodeResponse(lat: Double, lon: Double): Single<List<Restaurant?>> = apiDataHelper.getRemoteGeocodeResponse(lat, lon)

    override fun getLocalGeocodeNearbyRestaurantsList(lat: Double, lon: Double) = databaseHelper.getLocalGeocodeNearbyRestaurantsList(lat, lon)
    override fun getLocalGeocodeResponse(lat: Double, lon: Double) = databaseHelper.getLocalGeocodeResponse(lat, lon)
    override fun setLocalGeocodeResponse(lat: Double, lon: Double, listOfRestaurants: List<Restaurant?>?) = databaseHelper.setLocalGeocodeResponse(lat, lon, listOfRestaurants)
    override fun addOrUpdateRestaurants(listOfRestaurants: List<Restaurant?>?) = databaseHelper.addOrUpdateRestaurants(listOfRestaurants)

    override fun getRemoteAfterCachingGeocodeResponse(lat: Double, lon: Double): Single<List<Restaurant?>> =
            getRemoteGeocodeResponse(lat,lon)
                    .doOnSuccess{
                        setLocalGeocodeResponse(lat,lon,it).subscribeOn(Schedulers.io())
                                .observeOn(Schedulers.io()).subscribe()
                        addOrUpdateRestaurants(it).subscribeOn(Schedulers.io())
                                .observeOn(Schedulers.io()).subscribe()
                    }

//    override fun getFromRemoteAndCache(lat: Double, lon: Double): Observable<List<Restaurant?>> = Observable.merge(getRemoteAfterCachingGeocodeResponse(lat,lon).toObservable(),getLocalGeocodeResponse(lat,lon))
    override fun getFromRemoteAndCache(lat: Double, lon: Double): Observable<List<Restaurant?>?> {
        return if(internetStateProvider.isOnline())
//            Observable.merge(getLocalGeocodeResponse(lat,lon),getRemoteAfterCachingGeocodeResponse(lat,lon).toObservable())
            getRemoteAfterCachingGeocodeResponse(lat,lon).toObservable()
        else
            getLocalGeocodeResponse(lat,lon)
    }
}